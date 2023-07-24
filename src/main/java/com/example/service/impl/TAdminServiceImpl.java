package com.example.service.impl;

import com.example.domain.TAdmin;
import com.example.mapper.TAdminMapper;
import com.example.service.TAdminService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


@Service
public class TAdminServiceImpl extends ServiceImpl<TAdminMapper, TAdmin> implements TAdminService {

}
