package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.TPark;
import com.example.domain.vo.PageVo;


public interface TParkService extends IService<TPark> {
    Page<TPark> getPage(PageVo page);
}


