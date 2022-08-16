package com.ouke.cloud.controller;

import com.ouke.cloud.entity.TDefault;
import com.ouke.cloud.entity.TDefaultDto;
import com.ouke.cloud.result.ResultCode;
import com.ouke.cloud.result.ResultDTO;
import com.ouke.cloud.service.TDefaultService;
import com.ouke.cloud.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TDefaultController {
    @Autowired
    private TDefaultService tDefaultService;

    @GetMapping("/default")
    public ResultDTO<List<TDefaultDto>> queryAll() {
        List<TDefaultDto> tDefaults = tDefaultService.queryAll();
        ResultDTO<List<TDefaultDto>> listResultDTO = ResultUtils.successResult(tDefaults, (long) tDefaults.size());
        return listResultDTO;
    }

    @PostMapping("/add")
    public ResultDTO add(@Validated @RequestBody TDefault tDefault) {
        Assert.notNull(tDefault, "Input param is null.");
        TDefaultDto tDefaultDto = tDefaultService.create(tDefault);
        if (!ObjectUtils.isEmpty(tDefaultDto)) {
            return ResultUtils.successResult(tDefaultDto);
        }
        return ResultUtils.errorResult(String.valueOf(ResultCode.FAILED), ResultCode.FAILED.getMessage());

    }
}

