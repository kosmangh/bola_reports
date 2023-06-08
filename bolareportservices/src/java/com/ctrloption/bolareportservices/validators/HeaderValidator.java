package com.ctrloption.bolareportservices.validators;

import com.ctrloption.bolareportservices.ResponseCodes;
import com.ctrloption.bolareportservices.restmodels.commons.HeaderRequest;
import com.ctrloption.bolareportservices.restmodels.commons.HeaderResponse;
import com.ctrloption.bolareportservices.utils.AppLogger;
import com.ctrloption.bolareportservices.utils.AppUtils;
import java.io.IOException;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author dainoo
 */
public class HeaderValidator {

    private static final Logger log = Logger.getLogger(HeaderValidator.class.getName());

    public static HeaderResponse validateHeaderRequest(HeaderRequest request) throws IOException {
        log.info("validateHeader validate begins ");
        HeaderResponse headerResponse = new HeaderResponse();
        String msg = "validateHeader response";
        String lang = null;
        try {
            request.setLang("EN");
            request.setCompany("LOT");
            headerResponse.setCompany(request.getCompany());
            headerResponse.setRequestId(request.getRequestId());
            headerResponse.setSourceCode(request.getSourceCode());
            headerResponse.setResponseCode(ResponseCodes.FAILED);
            headerResponse.setResponseMessage(ResponseCodes.getAppMsg(ResponseCodes.FAILED));
            request.setLang("EN");
            if (null == request.getLang() || request.getLang().isEmpty()) {
                msg = ResponseCodes.getAppMsg(msg, "");
                headerResponse.setResponseCode(ResponseCodes.LANG_REQUIRED);
                headerResponse.setResponseMessage(msg);
                AppLogger.warn(log, msg);
                return headerResponse;
            }

            lang = request.getLang();
            log.info("lang " + lang);

            if (StringUtils.isEmpty(request.getCompany())) {
                msg = ResponseCodes.getAppMsg(ResponseCodes.COMPANY_REQUIRED);
                headerResponse.setResponseCode(ResponseCodes.COMPANY_REQUIRED);
                headerResponse.setResponseMessage(msg);
                AppLogger.printPayload(log, msg, headerResponse);
                return headerResponse;
            }
            if (StringUtils.isEmpty(request.getRequestId())) {
                msg = ResponseCodes.getAppMsg(ResponseCodes.REQUEST_ID_REQUIRED);
                headerResponse.setResponseCode(ResponseCodes.REQUEST_ID_REQUIRED);
                headerResponse.setResponseMessage(msg);
                AppLogger.printPayload(log, msg, headerResponse);
                return headerResponse;
            }
            if (StringUtils.isEmpty(request.getSourceCode())) {
                msg = ResponseCodes.getAppMsg(ResponseCodes.SOURCE_CODE_REQUIRED);
                headerResponse.setResponseCode(ResponseCodes.SOURCE_CODE_REQUIRED);
                headerResponse.setResponseMessage(msg);
                AppLogger.printPayload(log, msg, headerResponse);
                return headerResponse;
            }
            if (StringUtils.isEmpty(request.getRequestType())) {
                msg = ResponseCodes.getAppMsg(ResponseCodes.REQUIRED_TYPE_REQUIRED);
                headerResponse.setResponseCode(ResponseCodes.REQUIRED_TYPE_REQUIRED);
                headerResponse.setResponseMessage(msg);
                AppLogger.printPayload(log, msg, headerResponse);
                return headerResponse;
            }
            msg = ResponseCodes.getAppMsg(ResponseCodes.SUCCESS);
            headerResponse.setResponseCode(ResponseCodes.SUCCESS);
            headerResponse.setResponseMessage(msg);
            AppLogger.printPayload(log, " header validation status " + msg, headerResponse);
            log.info("validateHeader validate ends");
            return headerResponse;
        } catch (Exception e) {
            AppLogger.error(log, e, "validateHeader exception error");
            headerResponse = AppUtils.getErrorHeaderResponse(request);
            return headerResponse;
        }
    }

}
