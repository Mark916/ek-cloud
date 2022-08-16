package com.ouke.cloud.utils;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName SnowflakeUtil.java
 * @Author edison
 * @Version 1.0.0
 * @Description TODO
 * @CreateTime 2022年03月28日 19:21:00
 */
@Component
public class SnowflakeUtil {
    /**
     * endpoint machine id.
     */
    private long workerId = 0;

    /**
     * data center id.
     */
    private long dataCenterId = 1;

    /**
     * snowflake instance
     */
    private Snowflake snowflake;

    public long getWorkerId() {
        return workerId;
    }

    public long getDataCenterId() {
        return dataCenterId;
    }

    public Snowflake getSnowflake() {
        return snowflake;
    }

    public void setWorkerId(long workerId) {
        this.workerId = workerId;
    }

    public void setDataCenterId(long dataCenterId) {
        this.dataCenterId = dataCenterId;
    }

    public void setSnowflake(Snowflake snowflake) {
        this.snowflake = snowflake;
    }

    /**
     * initialize snowflake
     */
    @PostConstruct
    public void init() {
        workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        // worker Id should be in [0,31]
        workerId &= 0x1F;
        snowflake = IdUtil.createSnowflake(workerId, dataCenterId);
    }

    /**
     * get next id based on snowflake
     *
     * @return next id
     */
    public synchronized long nextId() {
        return snowflake.nextId();
    }
}
