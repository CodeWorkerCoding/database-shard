package com.nchu.tech.database.controller;

import com.alibaba.fastjson.JSON;
import com.nchu.tech.database.model.City;
import com.nchu.tech.database.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by fujianjian on 2017/7/5.
 */
@RestController
@RequestMapping("/city/")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addCity() {
        City city = new City();
        city.setCityName("上海市");
        city.setCode("0210030");
        city.setProvinceId("000000000000000000012445");
        this.cityService.createCity(city);
        return "success";
    }

    @RequestMapping(value = "get", method = RequestMethod.GET)
    public String getCity() {
        City city = this.cityService.findById("1499252271616");
        return JSON.toJSONString(city);

    }
}
