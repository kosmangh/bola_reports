package com.ctrloption.bolareportservices.models;

import com.ctrloption.bolareportservices.entities.bolareports.Revenuecollectors;

/**
 * @author Daud Ainoo
 * @Company CtrlOpton
 * @Contact 0245 293945
 * @Website ctrlOpton.com
 * @date Sun 12 Mar, 2023
 * @time 10.50.18 am
 */
public class Collector {

    private String collectorName;
    private String collectorId;


    public Collector() {
    }

    public Collector(Revenuecollectors eachObject) {
        collectorName = eachObject.getRevcollector();
        collectorId = eachObject.getRevcollectorID();
    }

    public String getCollectorName() {
        return collectorName;
    }

    public void setCollectorName(String collectorName) {
        this.collectorName = collectorName;
    }

    public String getCollectorId() {
        return collectorId;
    }

    public void setCollectorId(String collectorId) {
        this.collectorId = collectorId;
    }

}
