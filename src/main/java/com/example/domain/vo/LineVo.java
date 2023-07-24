package com.example.domain.vo;

import lombok.Data;

import java.util.List;


@Data
public class LineVo {
    private Object name;
    private Object type = "line";
    private Object smooth = true;
    private Object stack = "总量";
    private Object areaStyle = "{}";
    private List<Float> data;
}
