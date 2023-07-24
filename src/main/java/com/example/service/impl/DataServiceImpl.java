package com.example.service.impl;

import com.example.domain.TPark;
import com.example.service.DataService;
import com.example.service.TOrderService;
import com.example.service.TParkService;
import com.example.service.TUserService;
import com.example.util.DateUtils;
import com.example.domain.vo.DataVo;
import com.example.domain.vo.EchartVo;
import com.example.domain.vo.LineVo;
import com.example.domain.vo.response.LineRsp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
public class DataServiceImpl implements DataService {
    @Autowired
    private TUserService tUserService;
    @Autowired
    private TOrderService tOrderService;
    @Autowired
    private TParkService tParkService;

    @Override
    public DataVo getCountData() {
        DataVo vo = new DataVo();
        int userCount = tUserService.count();
        int parkCount = tParkService.count();
        int orderCount = tOrderService.count();
        float amount = tOrderService.getAmount();
        vo.setAmount(amount).setOrderCount(orderCount).setParkCount(parkCount)
                .setUserCount(userCount);
        return vo;
    }

    @Override
    public ArrayList<EchartVo> getParkData() {
        List<TPark> list = tParkService.list();
        ArrayList<EchartVo> vos = new ArrayList<>();
        for (TPark tPark : list) {
            EchartVo vo = new EchartVo();
            Integer value = tOrderService.countOrderForParkId(tPark.getId());
            vo.setValue(value);
            vo.setName(tPark.getParkName());
            vos.add(vo);
        }
        return vos;
    }
    // key 天数
    // value 值
    @Override
    public EchartVo getOrderData() {
        EchartVo vo = new EchartVo();
        // 得到天数
        ArrayList<Object> dayList = new ArrayList<>();
        ArrayList<Object> countList = new ArrayList<>();
        List<String> days = DateUtils.getDays(DateUtils.getStrDateBefore(new Date(), -5,"yyyy-MM-dd"), DateUtils.date2format(new Date(),"yyyy-MM-dd"), "yyyy-MM-dd");
        for (String day : days) {
            Integer count = tOrderService.countOrderForCreate(day);
            dayList.add(day);
            countList.add(count);
        }
        vo.setValue(countList);
        vo.setName(dayList);
        return vo;
    }

    @Override
    public LineRsp getAmountData() {
        LineRsp lineRsp = new LineRsp();
        ArrayList<Object> legend = new ArrayList<>();
        // 得到天数
        List<String> days = DateUtils.getDays(DateUtils.getStrDateBefore(new Date(), -5,"yyyy-MM-dd"), DateUtils.date2format(new Date()), "yyyy-MM-dd");
        // 得到停车场
        List<TPark> parkList = tParkService.list();
        ArrayList<LineVo> lineVos = new ArrayList<>();
        for (TPark tPark : parkList) {
            LineVo lineVo = new LineVo();
            ArrayList<Float>  data = new ArrayList<>();
            for (String day : days) {
                float amountForParkAndCreateTime = tOrderService.countAmountForParkAndCreateTime(tPark.getId(), day);
                data.add(amountForParkAndCreateTime);
            }
            legend.add(tPark.getParkName());
            lineVo.setName(tPark.getParkName());
            lineVo.setData(data);
            lineVos.add(lineVo);
        }

        lineRsp.setLegend(legend);
        lineRsp.setLineVo(lineVos);
        lineRsp.setXAxis(days);
        return lineRsp;
    }
}
