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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName NoModelDataListener.java
 * @Author edison
 * @Version 1.0.0
 * @Description TODO
 * @CreateTime 2022年03月22日 13:41:00
 */
public class NoModelDataListener extends AnalysisEventListener<Map<String, Object>> {

    private static final int BATCH_COUNT = 5;

    List<Map<String, Object>> list = new ArrayList<>();

    @Override
    public void invoke(Map<String, Object> data, AnalysisContext context) {
        this.list.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        saveData();
    }

    private void saveData() {}

    public List<Map<String, Object>> getList() {
        return this.list;
    }

    public void setList(List<Map<String, Object>> list) {
        this.list = list;
    }
}

