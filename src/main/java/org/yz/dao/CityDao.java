package org.yz.dao;

import org.yz.domain.City;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by 张鹏程 on 2017/6/7.
 */
@Repository
public interface CityDao {
    /**
     *  根据城市名称，查询城市信息
     * @param cityName 城市名
     * @return
     */
    City findByName(@Param("cityName") String cityName);
}
