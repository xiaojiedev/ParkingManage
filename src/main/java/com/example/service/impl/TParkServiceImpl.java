package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.vo.PageVo;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.TPark;
import com.example.mapper.TParkMapper;
import com.example.service.TParkService;


@Service
public class TParkServiceImpl extends ServiceImpl<TParkMapper, TPark> implements TParkService {

    @Override
    public Page<TPark> getPage(PageVo bean) {
        Page<TPark> page = new Page<>(bean.getPageNum(), bean.getPageSize());
        baseMapper.selectPage(page, null);
        return page;
    }
}


