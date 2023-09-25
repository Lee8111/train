package com.lizhengyu.train.business.controller.admin;

import com.lizhengyu.train.common.context.LoginMemberContext;
import com.lizhengyu.train.common.resp.CommonResp;
import com.lizhengyu.train.common.resp.PageResp;
import com.lizhengyu.train.business.req.DailyTrainQueryReq;
import com.lizhengyu.train.business.req.DailyTrainSaveReq;
import com.lizhengyu.train.business.resp.DailyTrainQueryResp;
import com.lizhengyu.train.business.service.DailyTrainService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/daily-train")
public class DailyTrainAdminController {

    @Resource
    private DailyTrainService dailyTrainService;

    @PostMapping("/save")
    public CommonResp<Object> save(@Valid @RequestBody DailyTrainSaveReq req) {
        dailyTrainService.save(req);
        return new CommonResp<>();
    }

    @GetMapping("/query-list")
    public CommonResp<PageResp<DailyTrainQueryResp>> queryList(@Valid DailyTrainQueryReq req) {
        PageResp<DailyTrainQueryResp> list = dailyTrainService.queryList(req);
        return new CommonResp<>(list);
    }

    @DeleteMapping("/delete/{id}")
    public CommonResp<Object> delete(@PathVariable Long id) {
        dailyTrainService.delete(id);
        return new CommonResp<>();
    }

}
