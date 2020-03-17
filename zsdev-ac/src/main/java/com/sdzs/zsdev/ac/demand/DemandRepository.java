package com.sdzs.zsdev.ac.demand;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright(C) ShanDongYinFang 2019.
 * <p>
 * web端项目信息Dao.
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
     * 查询项目信息列表.
     *
     *  @return 项目列表.
     */
    List<Map<String, Object>> demandQueryList(HashMap map);

    /*
    * 查询总条数
    * */
    int number();
}
