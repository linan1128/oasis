package com.oasis.admin.common.utils;

import java.io.Serializable;
import java.util.HashMap;

public class Result extends HashMap<String, Object> implements Serializable {
    private static final long serialVersionUID = 1L;

    public Result(){

    }
    public Result(int code, String msg, Object data) {
        this.setCode(code);
        this.setMsg(msg);
        this.setData(data);
    }
    public Integer getCode() {
        return (Integer)this.get("code");
    }

    public String getMsg() {
        return (String)this.get("msg");
    }

    public Object getData() {
        return this.get("data");
    }

    public void setCode(int code) {
        this.put("code", code);
    }

    public void setMsg(String msg) {
        this.put("msg", msg);
    }

    public void setData(Object data) {
        this.put("data", data);
    }

    public static Result ok() {
        return new Result(200, "ok", (Object)null);
    }

    public static Result ok(String msg) {
        return new Result(200, msg, (Object)null);
    }

    public static Result ok(Object data) {
        return new Result(200, "ok", data);
    }

    public static Result ok(String msg, Object data) {
        return new Result(200, msg, data);
    }

    public static Result error() {
        return new Result(500, "error", (Object)null);
    }

    public static Result error(String msg) {
        return new Result(500, msg, (Object)null);
    }


}
