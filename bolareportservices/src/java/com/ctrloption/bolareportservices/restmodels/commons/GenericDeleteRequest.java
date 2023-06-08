package com.ctrloption.bolareportservices.restmodels.commons;

import lombok.Data;

/**
 * @author Daud Ainoo
 * @Company CtrlOpton
 * @Contact 0245 293945
 * @Website ctrlOpton.com
 * @date Wed 15 Mar, 2023
 * @time 01.31.59 am
 */
@Data
public class GenericDeleteRequest {

    private HeaderRequest headerRequest;
    private String recordId;
    private String deletedBy;

}
