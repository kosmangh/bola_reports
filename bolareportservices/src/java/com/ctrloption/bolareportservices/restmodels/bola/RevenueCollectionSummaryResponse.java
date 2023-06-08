package com.ctrloption.bolareportservices.restmodels.bola;

import com.ctrloption.bolareportservices.models.ReportsModel;
import com.ctrloption.bolareportservices.restmodels.commons.HeaderResponse;
import java.util.List;

/**
 * @author Daud Ainoo
* @Company CtrlOpton
* @Contact 0245 293945
* @Website ctrlOpton.com
* @date Sat 01 Apr, 2023
* @time 13.28.54 pm
 */
public class RevenueCollectionSummaryResponse {
    private HeaderResponse headerResponse;
    private List<ReportsModel> payments;

    public HeaderResponse getHeaderResponse() {
        return headerResponse;
    }

    public void setHeaderResponse(HeaderResponse headerResponse) {
        this.headerResponse = headerResponse;
    }

    public List<ReportsModel> getPayments() {
        return payments;
    }

    public void setPayments(List<ReportsModel> payments) {
        this.payments = payments;
    }

}
