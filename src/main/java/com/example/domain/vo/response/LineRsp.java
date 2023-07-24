package com.example.domain.vo.response;

import com.example.domain.vo.LineVo;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class LineRsp {
    private ArrayList<LineVo> lineVo;
    private List<Object> legend;
    private List<String> xAxis;
}
