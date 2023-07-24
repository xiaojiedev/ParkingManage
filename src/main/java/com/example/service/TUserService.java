package com.example.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.TUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.domain.vo.PageVo;

import java.util.HashMap;


public interface TUserService extends IService<TUser> {
    Page<TUser> getPage(PageVo page);
    HashMap<String, Object> login(TUser tUser);
}

