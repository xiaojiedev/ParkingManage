package com.example.controller.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.TPark;
import com.example.service.TParkService;
import com.example.util.R;
import com.example.domain.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/park")
public class parkController {

    @Autowired
    private TParkService tParkService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public R save(@RequestBody TPark tPark){
        tParkService.save(tPark);
        return R.ok();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public R delete(@PathVariable("id") Integer id){
        tParkService.removeById(id);
        return R.ok();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public R get(@PathVariable("id") Integer id){
        TPark byId = tParkService.getById(id);
        return R.ok().data("data",byId);
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public R put(@RequestBody TPark tPark){
        tParkService.updateById(tPark);
        return R.ok();
    }

    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public R getList(@RequestBody PageVo bean) {
        Page<TPark> page = tParkService.getPage(bean);
        return R.ok().data("data",page);
    }

}

