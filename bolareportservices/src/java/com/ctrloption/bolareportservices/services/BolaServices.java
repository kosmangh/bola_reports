package com.ctrloption.bolareportservices.services;

import com.ctrloption.bolareportservices.ResponseCodes;
import com.ctrloption.bolareportservices.entities.bolareports.Revenuecollectors;
import com.ctrloption.bolareportservices.models.Collector;
import com.ctrloption.bolareportservices.models.ReportsModel;
import com.ctrloption.bolareportservices.restmodels.bola.CollectorsResponse;
import com.ctrloption.bolareportservices.restmodels.bola.RevenueCollectionSummaryRequest;
import com.ctrloption.bolareportservices.restmodels.bola.RevenueCollectionSummaryResponse;
import com.ctrloption.bolareportservices.restmodels.commons.HeaderRequest;
import com.ctrloption.bolareportservices.restmodels.commons.HeaderResponse;
import com.ctrloption.bolareportservices.services.jpa.BolaJpa;
import com.ctrloption.bolareportservices.utils.AppLogger;
import com.ctrloption.bolareportservices.utils.AppUtils;
import com.ctrloption.bolareportservices.validators.HeaderValidator;
//import com.ctrloption.bolareportservices.validators.HeaderValidator;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.apache.log4j.Logger;

/**
 * @author Daud Ainoo
 * @Company CtrlOpton
 * @Contact 0245 293945
 * @Website ctrlOpton.com
 * @date Sat 01 Apr, 2023
 * @time 12.10.49 pm
 */
@Stateless
public class BolaServices implements Serializable {

    private static final Logger log = Logger.getLogger(BolaServices.class.getName());

    @Inject
    private BolaJpa bolaJpa;

    public RevenueCollectionSummaryResponse getPayments(RevenueCollectionSummaryRequest request) throws IOException {
        RevenueCollectionSummaryResponse response = new RevenueCollectionSummaryResponse();
        HeaderResponse headerResponse = new HeaderResponse();
        try {
            headerResponse = HeaderValidator.validateHeaderRequest(request.getHeaderRequest());
            AppLogger.printPayload(log, "header re validation response before", headerResponse);
            if (!headerResponse.getResponseCode().equalsIgnoreCase(ResponseCodes.SUCCESS)) {
                response.setHeaderResponse(headerResponse);
                return response;
            }
            AppLogger.printPayload(log, "header validation response after", headerResponse);
            List<ReportsModel> payments = bolaJpa.fetchPayments(request);
            if (null == payments) {
                response.setHeaderResponse(AppUtils.getErrorHeaderResponse(request.getHeaderRequest()));
                response.setPayments(new ArrayList<>());
                return response;
            }
            headerResponse.setResponseCode(ResponseCodes.SUCCESS);
            headerResponse.setResponseMessage(ResponseCodes.getAppMsg(ResponseCodes.SUCCESS));
            response.setHeaderResponse(headerResponse);
            response.setPayments(payments);
            return response;
        } catch (IOException e) {
            AppLogger.error(log, e, "getPayments IOException");
            response.setHeaderResponse(AppUtils.getErrorHeaderResponse(request.getHeaderRequest()));
            return response;
        }
    }

    public CollectorsResponse getCollectors(HeaderRequest request) throws IOException {
        CollectorsResponse response = new CollectorsResponse();
        HeaderResponse headerResponse = new HeaderResponse();
        try {
            headerResponse = HeaderValidator.validateHeaderRequest(request);
            AppLogger.printPayload(log, "header re validation response before", headerResponse);
            if (!headerResponse.getResponseCode().equalsIgnoreCase(ResponseCodes.SUCCESS)) {
                response.setHeaderResponse(headerResponse);
                return response;
            }
            List<Revenuecollectors> listOfCollectors = bolaJpa.findAll(Revenuecollectors.class);
            if (null == listOfCollectors) {
                response.setHeaderResponse(AppUtils.getErrorHeaderResponse(request));
                return response;
            }
            List<Collector> collectors = bolaJpa.fetchCollectors();
            headerResponse.setResponseCode(ResponseCodes.SUCCESS);
            headerResponse.setResponseMessage(ResponseCodes.getAppMsg(ResponseCodes.SUCCESS));
            response.setHeaderResponse(headerResponse);
            response.setCollectors(collectors);
            return response;
        } catch (IOException e) {
            AppLogger.error(log, e, "getCollectors IOException");
            response.setHeaderResponse(AppUtils.getErrorHeaderResponse(request));
            return response;
        }
    }

}
