package com.lizhengyu.train.business.controller.admin;

import com.lizhengyu.train.common.context.LoginMemberContext;
import com.lizhengyu.train.common.resp.CommonResp;
import com.lizhengyu.train.common.resp.PageResp;
import com.lizhengyu.train.business.req.DailyTrainSeatQueryReq;
import com.lizhengyu.train.business.req.DailyTrainSeatSaveReq;
import com.lizhengyu.train.business.resp.DailyTrainSeatQueryResp;
import com.lizhengyu.train.business.service.DailyTrainSeatService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/daily-train-seat")
public class DailyTrainSeatAdminController {

    @Resource
    private DailyTrainSeatService dailyTrainSeatService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody DailyTrainSeatSaveReq req) {
        dailyTrainSeatService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainSeatQueryResp>> queryList(@Valid DailyTrainSeatQueryReq req) {
        PageResp<DailyTrainSeatQueryResp> list = dailyTrainSeatService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        dailyTrainSeatService.delete(id);
        return new CommonResp<>();
    }

}
