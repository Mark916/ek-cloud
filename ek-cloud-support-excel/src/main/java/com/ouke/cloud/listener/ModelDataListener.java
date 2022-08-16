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
import com.alibaba.excel.metadata.CellExtra;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName ModelDataListener.java
 * @Author edison
 * @Version 1.0.0
 * @Description TODO
 * @CreateTime 2022年03月22日 13:54:00
 */
public class ModelDataListener<T> extends AnalysisEventListener<T> {

    private List<T> datas = new ArrayList<>();
    private int headSize;

    @Override
    public void onException(Exception exception, AnalysisContext context) throws Exception {

    }

    @Override
    public void invoke(T t, AnalysisContext analysisContext) {
        if (!ObjectUtils.isEmpty(t)) {
            this.datas.add(t);
        }
    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        super.invokeHeadMap(headMap, context);
        this.headSize = headMap.size();
    }

    @Override
    public void extra(CellExtra extra, AnalysisContext context) {
        super.extra(extra, context);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    @Override
    public boolean hasNext(AnalysisContext context) {
        return super.hasNext(context);
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}
