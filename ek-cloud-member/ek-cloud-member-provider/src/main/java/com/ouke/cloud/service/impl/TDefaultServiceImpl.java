package com.ouke.cloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.Page;
import com.ouke.cloud.entity.TDefault;
import com.ouke.cloud.entity.TDefaultDto;
import com.ouke.cloud.mapper.TDefaultMapper;
import com.ouke.cloud.result.Asserts;
import com.ouke.cloud.service.TDefaultService;
import com.ouke.cloud.utils.SnowflakeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service("tDefaultService")
public class TDefaultServiceImpl extends ServiceImpl<TDefaultMapper, TDefault> implements TDefaultService {
    private static final Logger logger = LoggerFactory.getLogger(TDefaultServiceImpl.class);

    @Autowired
    private SnowflakeUtil snowflakeUtil;

    @Override
    public List<TDefaultDto> queryAll() {
        List<TDefaultDto> tDefaultDtos = this.baseMapper.selectAll();
        logger.info("------------info--------------{}", tDefaultDtos.size());

        if (tDefaultDtos.size() > 0) {
            return tDefaultDtos;
        }
        return new ArrayList<>();
    }

    @Override
    public Page<TDefaultDto> queryDefaultPagesByCondition(TDefault vo) {

        return null;
    }

    @Override
    public TDefaultDto create(TDefault tDefault) {
        if (tDefault == null) {
            Asserts.failInvalidParam();
        }
        if (tDefault.getId() == null) {
            long l = IdUtil.getSnowflake().nextId();
            logger.info("--------------------------------------"+l);
            tDefault.setId(100L);
        }
        tDefault.setAliveFlag(1);
        tDefault.setCreateTime(LocalDateTime.now());
        boolean save = this.save(tDefault);
        if (!save) {
            Asserts.fail("save fail!");
        }
        TDefaultDto tDefaultDto = new TDefaultDto();
        BeanUtils.copyProperties(tDefault,tDefaultDto);
        return tDefaultDto;
    }
}
