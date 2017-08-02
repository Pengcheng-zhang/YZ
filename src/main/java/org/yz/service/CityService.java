package org.yz.service;

import org.yz.domain.City;

/**
 * Created by 张鹏程 on 2017/6/7.
 */
public interface CityService {

    City findCityByName( String cityName);
}
