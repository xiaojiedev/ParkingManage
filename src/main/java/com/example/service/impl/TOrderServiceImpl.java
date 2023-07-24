package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.util.DateUtils;
import com.example.domain.vo.PageVo;
import com.example.domain.TOrder;
import com.example.mapper.TOrderMapper;
import com.example.service.TOrderService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.List;


@Service
public class TOrderServiceImpl extends ServiceImpl<TOrderMapper, TOrder> implements TOrderService {

    @Override
    public Page<TOrder> getPage(PageVo bean) {
        Page<TOrder> page = new Page<TOrder>(bean.getPageNum(), bean.getPageSize());
        baseMapper.selectPage(page, null);
        return page;
    }

    @Override
    public float getAmount() {
        float sum = 0;
        List<TOrder> orderList = baseMapper.selectList(null);
        for (TOrder order : orderList) {
            sum+=order.getPayment();
        }
        return sum;
    }

    @Override
    public Integer countOrderForParkId(Integer parkId) {
        QueryWrapper<TOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("park_id",parkId);
        Integer count = baseMapper.selectCount(wrapper);
        return count;
    }

    @Override
    public Integer countOrderForCreate(String time) {
        QueryWrapper<TOrder> wrapper = new QueryWrapper<>();
        wrapper.apply("UNIX_TIMESTAMP(create_time) >= UNIX_TIMESTAMP('" + time  + "')");
        String endDate = DateUtils.beforeStringDate(time, 1, "yyyy-MM-dd");
        wrapper.apply("UNIX_TIMESTAMP(create_time) <= UNIX_TIMESTAMP('" + endDate  + "')");
        Integer count = baseMapper.selectCount(wrapper);
        return count;
    }

    @Override
    public float countAmountForParkAndCreateTime(Integer parkId, String time) {
        QueryWrapper<TOrder> wrapper = new QueryWrapper<>();
        wrapper.eq("park_id",parkId);
        //String strStart= DateFormatUtils.format(time,"yyyy-MM-dd HH:mm:ss");
        String endDate = DateUtils.beforeStringDate(time, 1, "yyyy-MM-dd");
        wrapper.apply("UNIX_TIMESTAMP(create_time) >= UNIX_TIMESTAMP('" + time  + "')");
        wrapper.apply("UNIX_TIMESTAMP(create_time) <= UNIX_TIMESTAMP('" + endDate  + "')");
        List<TOrder> tOrderList = baseMapper.selectList(wrapper);
        float sum = 0;
        for (TOrder order : tOrderList) {
            sum+=order.getPayment();
        }
        return sum;
    }
}
