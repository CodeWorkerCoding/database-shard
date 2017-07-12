package com.nchu.tech.database.service.impl;

import com.nchu.tech.database.annotation.ReadOnlyConnection;
import com.nchu.tech.database.mapper.CityMapper;
import com.nchu.tech.database.model.City;
import com.nchu.tech.database.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by fujianjian on 2017/7/5.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;

    @Override
    public City createCity(City city) {
        city.setId(System.currentTimeMillis() + "");
        city.setCreateDate(new Date());
        this.cityMapper.save(city);
        return null;
    }

    @ReadOnlyConnection
    @Override
    public City findById(String id) {
        return this.cityMapper.findById(id);
    }
}
