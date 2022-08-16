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

/**
 * @ClassName AbstractModel.java
 * @Author edison
 * @Version 1.0.0
 * @Description TODO 有分页需求类继承此类
 * @CreateTime 2022年03月25日 11:01:00
 */
public abstract class AbstractModel {

    private PagesInfo pagesInfo;

    public AbstractModel(PagesInfo pagesInfo) {
        this.pagesInfo = pagesInfo;
    }

    public PagesInfo getPagesInfo() {
        return pagesInfo;
    }

    public void setPagesInfo(PagesInfo pagesInfo) {
        this.pagesInfo = pagesInfo;
    }
}
