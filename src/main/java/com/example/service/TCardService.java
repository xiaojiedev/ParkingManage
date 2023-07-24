package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.TCard;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.vo.PageVo;


public interface TCardService extends IService<TCard> {
    Page<TCard> getPage(PageVo page);
}



