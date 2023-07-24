package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.vo.PageVo;
import com.example.domain.TUser;
import com.example.mapper.TUserMapper;
import com.example.service.TUserService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import java.util.HashMap;
import java.util.Objects;


@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

    @Override
    public Page<TUser> getPage(PageVo bean) {
        Page<TUser> page = new Page<TUser>(bean.getPageNum(), bean.getPageSize());
        baseMapper.selectPage(page, null);
        return page;
    }

    @Override
    public HashMap<String, Object> login(TUser tUser) {
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username",tUser.getUsername());
        HashMap<String, Object> map = new HashMap<>();
        TUser dbUser = baseMapper.selectOne(wrapper);
        if(Objects.isNull(dbUser)){
            map.put("res",0);
            map.put("data","不存在");
        }else if(dbUser.getStatus()==1){
            map.put("res",0);
            map.put("data","冻结");
        }else if(!dbUser.getPassword().equals(tUser.getPassword())){
            map.put("res",0);
            map.put("data","密码错误");
        }else{
            map.put("res",1);
            map.put("data", dbUser.getUsername());
        }
        return map;
    }
}

