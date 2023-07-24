package com.example.controller.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.TUser;
import com.example.service.TUserService;
import com.example.util.R;
import com.example.domain.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/user")
public class userController {
    @Autowired
    private TUserService tUserService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public R save(@RequestBody TUser tUser){
        tUser.setPassword("123456");
        tUserService.save(tUser);
        return R.ok();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public R delete(@PathVariable("id") Integer id){
        tUserService.removeById(id);
        return R.ok();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public R get(@PathVariable("id") Integer id){
        TUser byId = tUserService.getById(id);
        return R.ok().data("data",byId);
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public R put(@RequestBody TUser tUser){
        tUserService.updateById(tUser);
        return R.ok();
    }

    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public R getList(@RequestBody PageVo bean) {
        Page<TUser> page = tUserService.getPage(bean);
        return R.ok().data("data",page);
    }
}
