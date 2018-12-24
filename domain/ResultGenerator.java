package com.pp.learn.demo.domain;

import com.pp.learn.demo.Result;
import com.pp.learn.demo.ResultCode;


/**
 * 响应结果生成工具
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    /**
     * 一般返回结果
     * @return
     */
    public static Result genSuccessResult() {
        return new GeneralResult()
                .setCode(ResultCode.SUCCESS)
                .setMsg(DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result genSuccessResult(Object data) {
        return new GeneralResult()
                .setCode(ResultCode.SUCCESS)
                .setMsg(DEFAULT_SUCCESS_MESSAGE)
                .setData(data);
    }

    public static Result genFailResult(String message) {
        return new GeneralResult()
                .setCode(ResultCode.FAIL)
                .setMsg(message);
    }

    /**
     * layui的table响应结果封装 返回结果
     * @return
     */
    public static Result genSuccessTableResult(long count,Object data) {
        return new TableResult()
                .setCode(ResultCode.SUCCESS)
                .setMsg(DEFAULT_SUCCESS_MESSAGE)
                .setCount(count)
                .setData(data);
    }

    public static Result genFailTableResult(String msg) {
        return new TableResult()
                .setCode(ResultCode.FAIL)
                .setMsg(msg);
    }

}
