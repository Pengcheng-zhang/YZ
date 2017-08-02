package org.yz.service.impl;

import org.yz.dao.CityDao;
import org.yz.domain.City;
import org.yz.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 张鹏程 on 2017/6/7.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    public City findCityByName(String cityName) {
        return cityDao.findByName(cityName);
    }
}
