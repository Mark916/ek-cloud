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

package com.ouke.cloud.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.ouke.cloud.JsonUtil;
import com.ouke.cloud.core.ExcelValidator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ValidatorDataListener.java
 * @Author edison
 * @Version 1.0.0
 * @Description TODO
 * @CreateTime 2022年03月22日 14:06:00
 */
public class ValidatorDataListener extends AnalysisEventListener<Object> {

    private int headSize;

    private List<Object> dataList = new ArrayList<>();

    private List<Object> errorDataList = new ArrayList<>();

    private Map<String, List<Object>> resultMap = new HashMap<>();

    @Override
    public void invoke(Object object, AnalysisContext context) {
        String message = null;
        try {
            message = ExcelValidator.validateEntity(object);
        } catch (NoSuchFieldException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        if (null != message && !message.isEmpty()) {
            this.errorDataList.add(JsonUtil.toJson(object) + message);
        } else if (object != null) {
            this.dataList.add(object);
        }
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        super.invokeHeadMap(headMap, context);
        this.headSize = headMap.size();
    }

    public int getHeadSize() {
        return this.headSize;
    }

    public void setHeadSize(int headSize) {
        this.headSize = headSize;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        this.resultMap.put("data", this.dataList);
        this.resultMap.put("error", this.errorDataList);
    }

    public List<Object> getDataList() {
        return this.dataList;
    }

    public void setDataList(List<Object> dataList) {
        this.dataList = dataList;
    }

    public List<Object> getErrorDataList() {
        return this.errorDataList;
    }

    public void setErrorDataList(List<Object> errorDataList) {
        this.errorDataList = errorDataList;
    }

    public Map<String, List<Object>> getResultMap() {
        return this.resultMap;
    }

    public void setResultMap(Map<String, List<Object>> resultMap) {
        this.resultMap = resultMap;
    }
}
