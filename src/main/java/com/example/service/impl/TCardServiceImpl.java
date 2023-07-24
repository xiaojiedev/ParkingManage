package com.example.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.vo.PageVo;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.domain.TCard;
import com.example.mapper.TCardMapper;
import com.example.service.TCardService;


@Service
public class TCardServiceImpl extends ServiceImpl<TCardMapper, TCard> implements TCardService {

    @Override
    public Page<TCard> getPage(PageVo bean) {
        Page<TCard> page = new Page<>(bean.getPageNum(), bean.getPageSize());
        baseMapper.selectPage(page, null);
        return page;
    }
}




