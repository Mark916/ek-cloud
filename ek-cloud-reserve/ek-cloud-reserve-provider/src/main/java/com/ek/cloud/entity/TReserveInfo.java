package com.ouke.cloud.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author adison
 * @since 2022-08-17
 */
public class TReserveInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 预约活动id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品编号
     */
    private Long skuId;

    /**
     * 预约开始时间
     */
    private LocalDateTime reserveStartTime;

    /**
     * 预约结束时间
     */
    private LocalDateTime reserveEndTime;

    /**
     * 秒杀开始时间
     */
    private LocalDateTime seckillStartTime;

    /**
     * 秒杀结束时间
     */
    private LocalDateTime seckillEndTime;

    /**
     * 活动创建人
     */
    private String creator;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 是否删除
     */
    private Integer yn;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSkuId() {
        return skuId;
    }

    public void setSkuId(Long skuId) {
        this.skuId = skuId;
    }

    public LocalDateTime getReserveStartTime() {
        return reserveStartTime;
    }

    public void setReserveStartTime(LocalDateTime reserveStartTime) {
        this.reserveStartTime = reserveStartTime;
    }

    public LocalDateTime getReserveEndTime() {
        return reserveEndTime;
    }

    public void setReserveEndTime(LocalDateTime reserveEndTime) {
        this.reserveEndTime = reserveEndTime;
    }

    public LocalDateTime getSeckillStartTime() {
        return seckillStartTime;
    }

    public void setSeckillStartTime(LocalDateTime seckillStartTime) {
        this.seckillStartTime = seckillStartTime;
    }

    public LocalDateTime getSeckillEndTime() {
        return seckillEndTime;
    }

    public void setSeckillEndTime(LocalDateTime seckillEndTime) {
        this.seckillEndTime = seckillEndTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    @Override
    public String toString() {
        return "TReserveInfo{" +
        "id=" + id +
        ", skuId=" + skuId +
        ", reserveStartTime=" + reserveStartTime +
        ", reserveEndTime=" + reserveEndTime +
        ", seckillStartTime=" + seckillStartTime +
        ", seckillEndTime=" + seckillEndTime +
        ", creator=" + creator +
        ", updateTime=" + updateTime +
        ", yn=" + yn +
        "}";
    }
}
