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

package com.ouke.cloud.core;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.ouke.cloud.exception.ExcelException;
import com.ouke.cloud.listener.ModelDataListener;
import com.ouke.cloud.listener.NoModelDataListener;
import com.ouke.cloud.listener.ValidatorDataListener;

import java.io.*;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName ExcelManager.java
 * @Author edison
 * @Version 1.0.0
 * @Description TODO
 * @CreateTime 2022年03月22日 13:26:00
 */
public class ExcelManager {
    public <R, D> void writeWithModel(String filePath, String fileName, Class<R> clazz, String sheetName, List<D> dataList) {
        String absoluteName = filePath + File.separator + fileName;
        try {
            EasyExcel.write(absoluteName, clazz).sheet(sheetName).doWrite(dataList);
        } catch (ExcelException e) {
            e.getStackTrace();
        }
    }

    public <R, D> InputStream writeWithModelAlsoReturnStream(String fileName, Class<R> clazz, List<D> dataList) {
        InputStream input = null;
        try {
            File tempFile = File.createTempFile("tempExcel", ".xlsx");
            EasyExcel.write(tempFile, clazz).sheet("sheet1").doWrite(dataList);
            input = getInputStreamByAbsoluteName(tempFile.getAbsolutePath());
        } catch (ExcelException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public <R, D> InputStream writeWithModelMultipleSheets(List<String> sheetNameList, List<Class<R>> clazzList, List<List<D>> dataList, List<Boolean> needHeadList) {
        InputStream input = null;
        try {
            File tempFile = File.createTempFile("tempExcel", ".xlsx");
            WriteSheet sheet = null;
            ExcelWriter excelWriter = EasyExcel.write(tempFile).build();
            for (int i = 0; i < clazzList.size(); i++) {
                sheet = ((ExcelWriterSheetBuilder) ((ExcelWriterSheetBuilder) EasyExcel.writerSheet(Integer.valueOf(i), sheetNameList.get(i)).needHead(needHeadList.get(i))).head(clazzList.get(i))).build();
                excelWriter.write(dataList.get(i), sheet);
            }
            excelWriter.finish();
            input = getInputStreamByAbsoluteName(tempFile.getAbsolutePath());
        } catch (ExcelException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return input;
    }

    public void writeWithoutModel(String filePath, String fileName, String sheetName, List<List<String>> headList, List<List<Object>> dataList) {
        String absoluteName = filePath + File.separator + fileName;
        try {
            ((ExcelWriterBuilder) EasyExcel.write(absoluteName).head(headList)).sheet(sheetName).doWrite(dataList);
        } catch (ExcelException e) {
            e.getStackTrace();
        }
    }

    private InputStream getInputStreamByAbsoluteName(String absoluteName) {
        InputStream input = null;
        File file = null;
        try {
            file = new File(absoluteName);
            input = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            file.delete();
        }
        return input;
    }
    public InputStream writeWithoutModelAlsoReturnStream(String fileName, List<List<String>> headList, List<List<Object>> dataList) {
        InputStream input = null;
        try {
            File tempFile = File.createTempFile("tempExcel", ".xlsx");
            ((ExcelWriterBuilder)EasyExcel.write(tempFile).head(headList)).sheet("sheet1").doWrite(dataList);
            input = getInputStreamByAbsoluteName(tempFile.getAbsolutePath());
        } catch (ExcelException|IOException e) {
            e.getStackTrace();
        }
        return input;
    }

    public <T> InputStream writeWithoutModelMultipleSheets(List<String> sheetNameList, List<List<List<String>>> headList, List<List<List<T>>> dataList, List<Boolean> needHeadList) {
        InputStream input = null;
        try {
            File tempFile = File.createTempFile("tempExcel", ".xlsx");
            ExcelWriter excelWriter = EasyExcel.write(tempFile).build();
            WriteSheet sheet1 = null;
            for (int i = 0; i < sheetNameList.size(); i++) {
                sheet1 = ((ExcelWriterSheetBuilder)((ExcelWriterSheetBuilder)EasyExcel.writerSheet(Integer.valueOf(i), sheetNameList.get(i)).head(headList.get(i))).needHead(needHeadList.get(i))).build();
                excelWriter.write(dataList.get(i), sheet1);
            }
            excelWriter.finish();
            input = getInputStreamByAbsoluteName(tempFile.getAbsolutePath());
        } catch (ExcelException|IOException e) {
            e.getStackTrace();
        }
        return input;
    }

    public List<Map<String, Object>> readResultMap(String filePath, String fileName) {
        String absoluteName = filePath + File.separator + fileName;
        NoModelDataListener noModelDataListener = new NoModelDataListener();
        try {
            EasyExcel.read(absoluteName, noModelDataListener).doReadAll();
        } catch (ExcelException e) {
            e.getStackTrace();
        }
        return noModelDataListener.getList();
    }

    public List<Map<String, Object>> readResultMapByInputStream(InputStream inputStream, String fileName) {
        NoModelDataListener noModelDataListener = new NoModelDataListener();
        try {
            EasyExcel.read(inputStream, noModelDataListener).doReadAll();
        } catch (ExcelException e) {
            e.getStackTrace();
        }
        return noModelDataListener.getList();
    }

    public <R> List<Object> readResultModel(String filePath, String fileName, Class<R> clazz) {
        String absoluteName = filePath + File.separator + fileName;
        ModelDataListener modelDataListener = new ModelDataListener();
        try {
            EasyExcel.read(absoluteName, clazz, modelDataListener).doReadAll();
        } catch (ExcelException e) {
            e.getStackTrace();
        }
        return modelDataListener.getDatas();
    }

    public <R> Map<String, List<Object>> readResultModelValidator(String filePath, String fileName, Class<R> clazz, Integer sheetNo) {
        String absoluteName = filePath + File.separator + fileName;
        ExcelReader excelReader = null;
        ValidatorDataListener validatorDataListener = new ValidatorDataListener();
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream(absoluteName));
            excelReader = EasyExcel.read(inputStream, clazz, validatorDataListener).build();
            ReadSheet readSheet = EasyExcel.readSheet(sheetNo).build();
            excelReader.read(new ReadSheet[] { readSheet });
        } catch (ExcelException e) {
            e.getStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            excelReader.finish();
        }
        return validatorDataListener.getResultMap();
    }

    public <R> List<R> readResultModelSelfDefinedListener(InputStream inputStream, Class<R> clazz, Integer sheetNo, ModelDataListener listener) {
        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcel.read(inputStream, clazz, listener).build();
            ReadSheet readSheet = EasyExcel.readSheet(sheetNo).build();
            excelReader.read(readSheet);
        } catch (ExcelException e) {
            e.getStackTrace();
        } finally {
            excelReader.finish();
        }
        return listener.getDatas();
    }

    public <R> List<Map<String, Object>> readResultNoModelSelfDefinedListener(InputStream inputStream, Integer sheetNo, NoModelDataListener listener) {
        ExcelReader excelReader = null;
        try {
            excelReader = EasyExcel.read(inputStream, listener).build();
            ReadSheet readSheet = EasyExcel.readSheet(sheetNo).build();
            excelReader.read(readSheet);
        } catch (ExcelException e) {
            e.getStackTrace();
        } finally {
            excelReader.finish();
        }
        return listener.getList();
    }

    public <R> List<Object> readResultModelByInputStream(InputStream inputStream, String fileName, Class<R> clazz) {
        ModelDataListener modelDataListener = new ModelDataListener();
        try {
            EasyExcel.read(inputStream, clazz, modelDataListener).doReadAll();
        } catch (ExcelException e) {
            e.getStackTrace();
        }
        return modelDataListener.getDatas();
    }

    public void createNullExcel(String filePath, String fileName) {
        String absoluteName = filePath + File.separator + fileName;
        EasyExcel.write(absoluteName).build().finish();
    }

    public <R, D> void excludeWrite(String filePath, String fileName, List<String> excludeColumns, Class<R> objectClass, String sheetName, List<D> data) {
        String file = filePath + File.separator + fileName;
        Set<String> excludeColumnFiledNames = new HashSet<>(excludeColumns);
        ((ExcelWriterBuilder)EasyExcel.write(file, objectClass).excludeColumnFiledNames(excludeColumnFiledNames)).sheet(sheetName)
                .doWrite(data);
    }

    public <R, D> void includeWrite(String filePath, String fileName, List<String> includeColumns, Class<R> objectClass, String sheetName, List<D> data) {
        String file = filePath + File.separator + fileName;
        Set<String> includeColumnFiledNames = new HashSet<>(includeColumns);
        ((ExcelWriterBuilder)EasyExcel.write(file, objectClass).includeColumnFiledNames(includeColumnFiledNames)).sheet(sheetName)
                .doWrite(data);
    }

    public void fillExcel(String filePath, String fileName, List<Object> data, Map<String, Object> map, String tempFilePath, String tempFileName) {
        ExcelWriter excelWriter = EasyExcel.write(filePath + File.separator + fileName).withTemplate(tempFilePath + tempFileName).build();
        WriteSheet writeSheet = EasyExcel.writerSheet().build();
        FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
        excelWriter.fill(data, fillConfig, writeSheet);
        excelWriter.fill(map, writeSheet);
        excelWriter.finish();
    }
}
