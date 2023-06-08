package com.ctrloption.bolareportservices.restmodels.bola;

import com.ctrloption.bolareportservices.models.Collector;
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
public class CollectorsResponse {
    private HeaderResponse headerResponse;
    private List<Collector> collectors;

    public HeaderResponse getHeaderResponse() {
        return headerResponse;
    }

    public void setHeaderResponse(HeaderResponse headerResponse) {
        this.headerResponse = headerResponse;
    }

    public List<Collector> getCollectors() {
        return collectors;
    }

    public void setCollectors(List<Collector> collectors) {
        this.collectors = collectors;
    }

}
