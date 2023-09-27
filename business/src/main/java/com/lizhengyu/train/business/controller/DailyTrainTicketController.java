package com.lizhengyu.train.business.controller;

import com.lizhengyu.train.business.req.DailyTrainTicketQueryReq;
import com.lizhengyu.train.business.resp.DailyTrainTicketQueryResp;
import com.lizhengyu.train.business.service.DailyTrainTicketService;
import com.lizhengyu.train.common.resp.CommonResp;
import com.lizhengyu.train.common.resp.PageResp;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/daily-train-ticket")
public class DailyTrainTicketController {

    @Resource
    private DailyTrainTicketService dailyTrainTicketService;



    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainTicketQueryResp>> queryList(@Valid DailyTrainTicketQueryReq req) {
        PageResp<DailyTrainTicketQueryResp> list = dailyTrainTicketService.queryList(req);
        return new CommonResp<>(list);
    }


}
