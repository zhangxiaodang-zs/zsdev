package com.sdzs.zsdev.ac.demand;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright(C) ShanDongYinFang 2019.
 * <p>
 * web端需求信息Dao.
 *
 * @author 门海峰 2020/03/17.
 * @version V0.0.1.
 * <p>
 * 更新履历： V0.0.1 2020/03/17 门海峰 创建.
 */
@Mapper
@Repository
public interface DemandRepository {

    /**
     * 查询需求信息列表.
     *
     *  @return 需求列表.
     */
    List<Map<String, Object>> demandQueryList(HashMap map);
    List<Map<String, Object>> demandQueryListjq(HashMap map);

    /**
    * 查询总条数
    * */
    int number();

    /**
     * 添加.
     *
     * @param map 添加信息.
     * @return
     */
    int adddemand(HashMap map);

    /**
     * 需求信息修改.
     *
     * @param map 需求修改信息.
     */
    int editdemand(HashMap map);

    /**
     * 需求信息删除.
     *
     * @param map 需求信息删除.
     */
    int deldemand(Map<String, String> param);
}
