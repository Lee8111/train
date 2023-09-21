package com.lizhengyu.train.member.controller;

import com.lizhengyu.train.common.resp.CommonResp;
import com.lizhengyu.train.member.req.PassengerSaveReq;
import com.lizhengyu.train.member.service.PassengerService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Resource
    private PassengerService passengerService;

    @PostMapping("/save")
    public CommonResp<Long> register(@Valid @RequestBody PassengerSaveReq req){
        passengerService.save(req);
        return new CommonResp<>();

    }

}
