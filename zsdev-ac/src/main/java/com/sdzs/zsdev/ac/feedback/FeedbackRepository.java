package com.sdzs.zsdev.ac.feedback;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Copyright(C) ShanDongYinFang 2019.
 * <p>
 * web端任务信息Dao.
 *
 * @author 门海峰 2020/03/17.
 * @version V0.0.1.
 * <p>
 * 更新履历： V0.0.1 2020/03/17 门海峰 创建.
 */
@Mapper
@Repository
public interface FeedbackRepository {

    /**
     * 查询任务信息列表.
     *
     *  @return 任务列表.
     */
    List<Map<String, Object>> feedbackQueryList(HashMap map);
    List<Map<String, Object>> feedbackQueryListjq(HashMap map);

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
    int addtaskFeedback(HashMap map);

    /**
     * 任务反馈信息修改.
     *
     * @param map 任务修改信息.
     */
    int editfeedback(HashMap map);

    /**
     * 任务反馈信息删除.
     *
     * @param map 任务信息删除.
     */
    int delfeedback(Map<String, String> param);

}
