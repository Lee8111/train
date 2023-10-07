package com.lizhengyu.train.business.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.lizhengyu.train.business.req.ConfirmOrderDoReq;
import com.lizhengyu.train.business.service.ConfirmOrderService;
import com.lizhengyu.train.common.exception.BusinessExceptionEnum;
import com.lizhengyu.train.common.resp.CommonResp;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/confirm-order")
public class ConfirmOrderController {

    private static final Logger LOG = LoggerFactory.getLogger(ConfirmOrderController.class);
    @Resource
    private ConfirmOrderService confirmOrderService;

    @PostMapping("/do")
    @SentinelResource(value = "ConfirmOrderDo",blockHandler = "doConfirmBlock")
    public CommonResp<Object> doConfirm(@Valid @RequestBody ConfirmOrderDoReq req) {
        confirmOrderService.doConfirm(req);
        return new CommonResp<>();
    }
    public CommonResp<Object> doConfirmBlock(ConfirmOrderDoReq req, BlockException e){

        LOG.info("购票请求被限流：{}",req);
       // throw new BusinessException(BusinessExceptionEnum.CONFIRM_ORDER_FLOW_EXCEPTION);
        CommonResp<Object> commonResp = new CommonResp<>();
        commonResp.setSuccess(false);
        commonResp.setMessage(BusinessExceptionEnum.CONFIRM_ORDER_FLOW_EXCEPTION.getDesc());
        return commonResp;
    }

}
