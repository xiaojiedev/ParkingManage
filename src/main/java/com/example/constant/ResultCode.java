package com.example.constant;

import lombok.Getter;


@Getter
public enum ResultCode {
    SUCCESS(0),
    ERROR(500);

    private Integer code;

    ResultCode(Integer code) {
        this.code = code;
    }
}
