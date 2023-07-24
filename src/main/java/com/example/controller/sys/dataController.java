package com.example.controller.sys;

import com.example.service.DataService;
import com.example.util.R;
import com.example.domain.vo.DataVo;
import com.example.domain.vo.EchartVo;
import com.example.domain.vo.response.LineRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;


@RestController
@RequestMapping("/api/data")
public class dataController {
    @Autowired
    private DataService dataService;

    @RequestMapping(value = "/getCount",method = RequestMethod.POST)
    public R getCountData(){
        DataVo data = dataService.getCountData();
        return R.ok().data("data",data);
    }

    @RequestMapping(value = "/getParkData",method = RequestMethod.POST)
    public R getParkData(){
        ArrayList<EchartVo> parkData = dataService.getParkData();
        ArrayList<Object> nameList = new ArrayList<>();
        for (EchartVo datum : parkData) {
            nameList.add(datum.getName());
        }
        return R.ok().data("data",parkData).data("nameList", nameList);
    }

    @RequestMapping(value = "/getOrderData",method = RequestMethod.POST)
    public R getOrderData(){
        EchartVo orderData = dataService.getOrderData();
        return R.ok().data("data",orderData);
    }

    @RequestMapping(value = "/getAmountData",method = RequestMethod.POST)
    public R getAmountData(){
        LineRsp data = dataService.getAmountData();
        return R.ok().data("data",data);
    }
}
