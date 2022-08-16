package com.ouke.cloud.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.github.pagehelper.Page;
import com.ouke.cloud.entity.TDefault;
import com.ouke.cloud.entity.TDefaultDto;

import java.util.List;

public interface TDefaultService extends IService<TDefault> {
    /**
     * fetch all data
     *
     * @return Result<TDefaultDto>
     */

    List<TDefaultDto> queryAll();

    /**
     * fetch page data by vo
     *
     * @param vo vo
     * @return Result<TDefaultDto>
     */
    Page<TDefaultDto> queryDefaultPagesByCondition(TDefault vo);

    /**
     * fetch page data by vo
     *
     * @param tDefaultDto vo
     * @return Result<TDefaultDto>
     */
    TDefaultDto create(TDefault tDefault);

}
