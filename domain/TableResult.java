package com.pp.learn.demo.domain;

import com.pp.learn.demo.Result;
import com.pp.learn.demo.ResultCode;

/**
 * layui的table响应结果封装
 */
public class TableResult implements Result {
    private int code;
    private String msg;
    private long count;
    private Object data;

    public long getCount() {
        return count;
    }

    public TableResult setCount(long count) {
        this.count = count;
        return this;
    }

    public int getCode() {
        return code;
    }

    public TableResult setCode(ResultCode resultCode) {
        this.code = resultCode.code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public TableResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Object getData() {
        return data;
    }

    public TableResult setData(Object data) {
        this.data = data;
        return this;
    }

}
