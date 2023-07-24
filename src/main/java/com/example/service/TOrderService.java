package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.TOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.vo.PageVo;


public interface TOrderService extends IService<TOrder>{
    Page<TOrder> getPage(PageVo page);
    float getAmount();
    Integer countOrderForParkId(Integer parkId);
    Integer countOrderForCreate(String time);
    float countAmountForParkAndCreateTime(Integer parkId,String time);
}
