package com.ouke.cloud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import com.ouke.cloud.entity.TDefault;
import com.ouke.cloud.entity.TDefaultDto;

import java.util.List;

public interface TDefaultMapper extends BaseMapper<TDefault> {
    /**
     * fetch all data
     *
     * @return Result<TDefaultDto>
     */
    List<TDefaultDto> selectAll();

    /**
     * fetch data page
     *
     * @param vo json format context
     * @return Result<TDefaultDto>
     */
    Page<TDefaultDto> queryDefaultPagesByCondition(TDefault vo);

}
