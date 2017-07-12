package com.nchu.tech.database.service;

import com.nchu.tech.database.model.City;

/**
 * Created by fujianjian on 2017/7/5.
 */
public interface CityService {

    City createCity(City city);

    City findById(String id);
}
