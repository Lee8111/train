package com.lizhengyu.train.business.req;

import com.lizhengyu.train.common.req.PageReq;

public class TrainSeatQueryReq extends PageReq {
    private String trainCode;

    public String getTrainCode() {
        return trainCode;
    }

    public void setTrainCode(String trainCode) {
        this.trainCode = trainCode;
    }
    @Override
    public String toString() {
        return "TrainSeatQueryReq{" +
                "} " + super.toString();
    }
}
