package com.example.service;

import com.example.domain.vo.DataVo;
import com.example.domain.vo.EchartVo;
import com.example.domain.vo.response.LineRsp;

import java.util.ArrayList;


public interface DataService {
    /**
     * 控制台统计数据
     * @return
     */
    DataVo getCountData();
    ArrayList<EchartVo> getParkData();
    EchartVo getOrderData();
    LineRsp getAmountData();
}
