package com.example.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.domain.TUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Slf4j
@Component("MyUserDetailService")
public class MyUserDetailService implements UserDetailsService {
    @Autowired
    private BaseMapper<TUser> tUserBaseMapper;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        QueryWrapper<TUser> wrapper = new QueryWrapper<>();
        wrapper.eq("username", s);
        return tUserBaseMapper.selectOne(wrapper);
    }
}
