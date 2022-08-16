package com.ouke.cloud.utils;

import com.ouke.cloud.exception.BusinessException;
import com.ouke.cloud.result.ResultDTO;

/**
 * @ClassName ResultUtils.java
 * @Author edison
 * @Version 1.0.0
 * @Description TODO
 * @CreateTime 2022年03月28日 16:47:00
 */
public class ResultUtils {
    /**
     * 错误ResultDTO
     * @param code 代码
     * @param message 信息
     * @param <T> 返回类型
     * @return ResultDTO<T>
     */
    public static <T> ResultDTO<T> errorResult(String code, String message){
        ResultDTO<T> result=new ResultDTO<T>();
        result.setSuccess(false);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
    /**
     * 错误ResultDTO
     * @param message 信息
     * @param <T> 返回类型
     * @return ResultDTO<T>
     */
    public static <T> ResultDTO<T> errorResult(String message){
        ResultDTO<T> result=new ResultDTO<T>();
        result.setSuccess(false);
        result.setCode("500");
        result.setMessage(message);
        return result;
    }

    /**
     * 错误ResultDTO
     * @param exception 询价单异常
     * @param <T> 返回类型T
     * @return ResultDTO<T>
     */
    public static <T> ResultDTO<T> errorResult(BusinessException exception){
        ResultDTO<T> result=new ResultDTO<T>();
        result.setSuccess(false);
        result.setCode(exception.getCode());
        result.setMessage(exception.getMessage());
        return result;
    }

    /**
     * 错误ResultDTO
     * @param <T> 返回类型
     * @return ResultDTO<T>
     */
    public static <T> ResultDTO<T> errorResult(){
        ResultDTO<T> result=new ResultDTO<T>();
        result.setSuccess(false);
        result.setCode("500");
        result.setMessage("fail");
        return result;
    }
    /**
     * 成功ResultDTO
     * @param <T>
     * @return
     */
    public static <T> ResultDTO<T> successResult(){
        ResultDTO<T> result=new ResultDTO<T>();
        result.setSuccess(true);
        result.setCode("OK");
        result.setMessage("success");
        return result;
    }
    /**
     * 成功ResultDTO
     * @param code 代码
     * @param message 信息
     * @param <T> 返回类型
     * @return ResultDTO<T>
     */
    public static <T> ResultDTO<T> successResult(String code,String message){
        ResultDTO<T> result=new ResultDTO<T>();
        result.setSuccess(true);
        result.setCode(code);
        result.setMessage(message);
        return result;
    }
    /**
     * 成功ResultDTO
     * @param data 返回对象
     * @param <T> 返回类型
     * @return ResultDTO<T>
     */
    public static <T> ResultDTO<T> successResult(T data){
        ResultDTO<T> result=new ResultDTO<T>();
        result.setSuccess(true);
        result.setCode("OK");
        result.setMessage("success");
        result.setData(data);
        return result;
    }
    /**
     * 成功ResultDTO
     * @param data 返回对象
     * @param message 消息
     * @param <T> 返回类型
     * @return ResultDTO<T>
     */
    public static <T> ResultDTO<T> successResult(T data,String message){
        ResultDTO<T> result=new ResultDTO<T>();
        result.setSuccess(true);
        result.setCode("OK");
        result.setMessage(message);
        result.setData(data);
        return result;
    }
    /**
     * 成功ResultDTO
     * @param data 返回对象
     * @param code 代码
     * @param message 消息
     * @param <T> 返回类型
     * @return ResultDTO<T>
     */
    public static <T> ResultDTO<T> successResult(T data,String code,String message){
        ResultDTO<T> result=new ResultDTO<T>();
        result.setSuccess(true);
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
    /**
     * 成功ResultDTO
     * @param data 返回对象
     * @param total 总记录条数
     * @param <T> 返回类型
     * @return ResultDTO<T>
     */
    public static <T> ResultDTO<T> successResult(T data,Long total){
        ResultDTO<T> result=new ResultDTO<T>();
        result.setSuccess(true);
        result.setCode("OK");
        result.setMessage("success");
        result.setData(data);
        result.setTotal(total);
        return result;
    }
    /**
     * 成功ResultDTO
     * @param data 返回对象
     * @param message 消息
     * @param total 总记录条数
     * @param <T> 返回类型
     * @return ResultDTO<T>
     */
    public static <T> ResultDTO<T> successResult(T data,String message,Long total){
        ResultDTO<T> result=new ResultDTO<T>();
        result.setSuccess(true);
        result.setCode("OK");
        result.setMessage(message);
        result.setData(data);
        result.setTotal(total);
        return result;
    }
    /**
     * 成功ResultDTO
     * @param data 返回对象
     * @param code 代码
     * @param message 消息
     * @param total 总记录条数
     * @param <T> 返回类型
     * @return ResultDTO<T>
     */
    public static <T> ResultDTO<T> successResult(T data,String code,String message,Long total){
        ResultDTO<T> result=new ResultDTO<T>();
        result.setSuccess(true);
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        result.setTotal(total);
        return result;
    }
}
