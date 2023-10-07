package com.lizhengyu.train.batch.feign;

import com.lizhengyu.train.common.resp.CommonResp;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class BusinessFeignFallBack implements BusinessFeign{
    @Override
    public String hello() {
        return "FallBack";
    }

    @Override
    public CommonResp<Object> genDaily(Date date) {
        return null;
    }
}
