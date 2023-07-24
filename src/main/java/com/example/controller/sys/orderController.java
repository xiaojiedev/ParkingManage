package com.example.controller.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.TOrder;
import com.example.service.TOrderService;
import com.example.util.R;
import com.example.domain.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/order")
public class orderController {
    @Autowired
    private TOrderService tOrderService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public R save(@RequestBody TOrder bean){
        tOrderService.save(bean);
        return R.ok();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public R delete(@PathVariable("id") Integer id){
        tOrderService.removeById(id);
        return R.ok();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public R get(@PathVariable("id") Integer id){
        TOrder byId = tOrderService.getById(id);
        return R.ok().data("data",byId);
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public R put(@RequestBody TOrder bean){
        tOrderService.updateById(bean);
        return R.ok();
    }

    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public R getList(@RequestBody PageVo bean) {
        Page<TOrder> page = tOrderService.getPage(bean);
        return R.ok().data("data",page);
    }
}
