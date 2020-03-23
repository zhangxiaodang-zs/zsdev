package com.sdzs.zsdev.ac.project;

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
public interface ProjectRepository {

    /**
     * 查询项目信息列表.
     *
     *  @return 项目列表.
     */
    List<Map<String, Object>> projectQueryList(HashMap map);
    List<Map<String, Object>> queryFileList(HashMap map);
    List<Map<String, Object>> projectQueryListjq(HashMap map);

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
    int addproject(HashMap map);

    /**
     * 项目信息修改.
     *
     * @param map 项目修改信息.
     */
    int editproject(HashMap map);

    /**
     * 项目信息删除.
     *
     * @param map 项目信息删除.
     */
    int delproject(Map<String, String> param);

    /**
     * 附件添加.
     *
     * @param map 添加信息.
     * @return
     */
    int addannex(Map<String, String> map);

    /**
     * 附件删除.
     *
     * @param map 项目信息删除.
     */
    int delfile(Map<String, String> param);
}
