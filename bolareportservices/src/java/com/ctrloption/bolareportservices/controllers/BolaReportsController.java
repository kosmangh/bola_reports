package com.ctrloption.bolareportservices.controllers;

import com.ctrloption.bolareportservices.reports.ReportFiles;
import com.ctrloption.bolareportservices.restmodels.bola.CollectorsResponse;
import com.ctrloption.bolareportservices.restmodels.bola.RevenueCollectionSummaryRequest;
import com.ctrloption.bolareportservices.restmodels.bola.RevenueCollectionSummaryResponse;
import com.ctrloption.bolareportservices.restmodels.commons.GenericRequest;
import com.ctrloption.bolareportservices.restmodels.commons.HeaderResponse;
import com.ctrloption.bolareportservices.services.BolaServices;
import com.ctrloption.bolareportservices.utils.AppLogger;
import com.ctrloption.bolareportservices.utils.AppUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import org.apache.log4j.Logger;

/**
 * @author Daud Ainoo
 * @Company CtrlOpton
 * @Contact 0245 293945
 * @Website ctrlOpton.com
 * @date Sat 01 Apr, 2023
 * @time 13.11.32 pm
 */
@RequestScoped
@Path("reports")
public class BolaReportsController {

    private static final Logger log = Logger.getLogger(BolaReportsController.class.getName());

    @Inject
    private BolaServices bolaService;

    @POST
    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/revenuereport")
    public Response generateReportPDF(RevenueCollectionSummaryRequest request) {

        try {
            log.info("setting parameters before report file");

            // Load the Jasper report file
            InputStream reportInputStream = getClass().getResourceAsStream(ReportFiles.revenue_collection_summary_report);
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportInputStream);

            log.info("setting parameters");
            // Set report parameters
            Map<String, Object> parameters = new HashMap<>();
            parameters.put("companyName", "JEKORA VENTURES LTD");
            parameters.put("reportTitle", "REVENUE COLLECTION SUMMARY SHEET");
            parameters.put("footerTitle", "JEKORA VENTURES LTD - Revenue collection summary sheet");
            parameters.put("printedBy", "Daud");
            parameters.put("ward", "Daud");

            RevenueCollectionSummaryResponse summaryResponse = bolaService.getPayments(request);
            AppLogger.printPayload(log, "data reponse", summaryResponse);

            // Create a data source for the report
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(summaryResponse.getPayments());

            // Fill the report with data
            JasperPrint jasperPrint = net.sf.jasperreports.engine.JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            // Export the report to PDF
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            net.sf.jasperreports.engine.JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

            // Set response headers
            Response.ResponseBuilder responseBuilder = Response.ok(outputStream.toByteArray());
            responseBuilder.header("Content-Disposition", "attachment; filename=report.pdf");
            responseBuilder.header("Content-Type", "application/pdf");

            // Return the response with the PDF
            return responseBuilder.build();

        } catch (IOException | JRException e) {
            AppLogger.error(log, e, "Error printing");
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error generating report.").build();
        }
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path(value = "/collectors")
    public CollectorsResponse doFetchCollectors(GenericRequest request) {
//        MDC.put("requestid", request.getRequestId());
        CollectorsResponse response = new CollectorsResponse();
        HeaderResponse headerResponse = new HeaderResponse();
        try {
            AppLogger.printPayload(log, "collectorsRequest ", request);
            response = bolaService.getCollectors(request.getHeaderRequest());
            AppLogger.printPayload(log, "collectorsResponse ", response);
        } catch (IOException e) {
            AppLogger.error(log, e, "collectorsRequest IOException");
            response.setHeaderResponse(AppUtils.getErrorHeaderResponse(request.getHeaderRequest()));
            response.setHeaderResponse(headerResponse);
            return response;
        }
//        MDC.remove("requestid");
        return response;
    }

}
