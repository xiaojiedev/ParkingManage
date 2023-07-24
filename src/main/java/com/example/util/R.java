package com.example.util;

import com.example.constant.ResultCode;
import lombok.Data;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;


@ToString
@Data
public class R {
    private Boolean success;
    private Integer code;
    private String message;
    private Map data = new HashMap<String, Object>();

    /**
     * 把构造方法私有
     */
    private R() {
    }

    /**
     * 成功静态方法
     *
     * @return
     */
    public static R ok() {
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS.getCode());
        r.setMessage("成功");
        return r;
    }

    /**
     * 失败静态方法
     *
     * @return
     */
    public static R error() {
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR.getCode());
        r.setMessage("失败");
        return r;
    }

    public R success(Boolean success) {
        this.setSuccess(success);
        return this;
    }

    public R message(String message) {
        this.setMessage(message);
        return this;
    }

    public R code(Integer code) {
        this.setCode(code);
        return this;
    }

    public R data(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map) {
        this.setData(map);
        return this;
    }
}
