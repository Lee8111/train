package com.lizhengyu.train.member.controller;

import com.lizhengyu.train.common.context.LoginMemberContext;
import com.lizhengyu.train.common.resp.CommonResp;
import com.lizhengyu.train.common.resp.PageResp;
import com.lizhengyu.train.member.req.PassengerQueryReq;
import com.lizhengyu.train.member.req.PassengerSaveReq;
import com.lizhengyu.train.member.resp.PassengerQueryResp;
import com.lizhengyu.train.member.service.PassengerService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/query-list")
    public CommonResp<PageResp<PassengerQueryResp>> queryList(@Valid PassengerQueryReq req){
        req.setMemberId(LoginMemberContext.getId());
        PageResp<PassengerQueryResp> list = passengerService.queryList(req);
        return new CommonResp<>(list);

    }
    @DeleteMapping("/delete/{id}")
    public CommonResp<Long> delete(@PathVariable Long id){
        passengerService.delete(id);
        return new CommonResp<>();

    }

}
