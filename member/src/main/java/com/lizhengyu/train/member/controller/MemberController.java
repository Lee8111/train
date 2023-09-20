package com.lizhengyu.train.member.controller;

import com.lizhengyu.train.common.resp.CommonResp;
import com.lizhengyu.train.member.req.MemberLoginReq;
import com.lizhengyu.train.member.req.MemberRegisterReq;
import com.lizhengyu.train.member.req.MemberSendCodeReq;
import com.lizhengyu.train.member.resp.MemberLoginResp;
import com.lizhengyu.train.member.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private MemberService memberService;
    @GetMapping("/count")
    public CommonResp<Integer> count(){

        return new CommonResp<>(memberService.count());

    }
    @PostMapping("/register")
    public CommonResp<Long> register(@Valid MemberRegisterReq req){

        return new CommonResp<>(memberService.register(req));

    }
    @PostMapping("/send-code")
    public CommonResp<Long> sendCode(@Valid @RequestBody MemberSendCodeReq req){

       memberService.sendCode(req);

       return new CommonResp<>();

    }
    @PostMapping("/login")
    public CommonResp<MemberLoginResp> login(@Valid @RequestBody MemberLoginReq req){

        return new CommonResp<>(memberService.login(req));

    }
}
