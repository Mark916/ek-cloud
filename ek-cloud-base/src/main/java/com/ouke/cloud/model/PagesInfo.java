/*
 *
 *  Guangdong Ouke Air Conditioning refrigeration Co., LTD
 *
 *  (C) Copyright Guangdong Ouke Air Conditioning refrigeration Co., LTD. 2022 All Rights Reserved.
 *
 *  NOTICE:  All information contained herein is, and remains the property of
 *  Guangdong Ouke Air Conditioning refrigeration Co., LTD, Co.,Ltd. The intellectual property herein
 *  are protected by trade secret, patent law or copyright law. Dissemination
 *  of this information or reproduction of this material is strictly forbidden
 *  unless prior written permission is obtained from Guangdong Ouke Air Conditioning refrigeration Co., LTD.
 *
 *  http://www.euroklimat.com.cn/
 *
 *
 */

package com.ouke.cloud.model;

import java.io.Serializable;
import java.util.StringJoiner;

/**
 * @ClassName PagesInfo.java
 * @Author edison
 * @Version 1.0.0
 * @Description TODO
 * @CreateTime 2022年03月25日 10:48:00
 */
public class PagesInfo implements Serializable {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private Boolean isCount;

    public PagesInfo(Boolean isCount) {
        this.isCount = isCount;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Boolean getCount() {
        return isCount;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setCount(Boolean count) {
        isCount = count;
    }

    @Override
    public String toString() {
        return (new StringJoiner(", ", PagesInfo.class.getSimpleName() + "[", "]")).add("pageNum=" + this.pageNum).add("pageSize=" + this.pageSize).add("isCount=" + this.isCount).toString();
    }
}
