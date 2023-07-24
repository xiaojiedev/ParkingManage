package com.example.controller.sys;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.domain.TCard;
import com.example.service.TCardService;
import com.example.service.TParkService;
import com.example.util.DateUtils;
import com.example.util.R;
import com.example.domain.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


@RestController
@RequestMapping("/api/card")
public class cardController {
    @Autowired
    private TCardService tCardService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public R save(@RequestBody TCard tCard){
        tCard.setOpenDate(new Date());
        int differentDays = DateUtils.differentDays(tCard.getStartDate(), new Date());
        tCard.setLeftDay(tCard.getCardDay()-differentDays);
        tCard.setOpenDate(new Date());
        if(differentDays > 0){
            tCard.setStatus(1);
        }else{
            tCard.setStatus(0);
        }
        tCardService.save(tCard);
        return R.ok();
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public R delete(@PathVariable("id") Integer id){
        tCardService.removeById(id);
        return R.ok();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public R get(@PathVariable("id") Integer id){
        TCard byId = tCardService.getById(id);
        return R.ok().data("data",byId);
    }

    @RequestMapping(value = "/put", method = RequestMethod.PUT)
    public R put(@RequestBody TCard tCard){
        tCardService.updateById(tCard);
        return R.ok();
    }

    @RequestMapping(value = "/getList", method = RequestMethod.POST)
    public R getList(@RequestBody PageVo bean) {
        Page<TCard> page = tCardService.getPage(bean);
        return R.ok().data("data",page);
    }
}
