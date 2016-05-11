package com.ssic.test.common.mapper;

import com.ssic.test.common.pojo.AvgScoreWarning;
import com.ssic.test.common.pojo.AvgScoreWarningExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface AvgScoreWarningMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_avg_score_warning
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int countByExample(AvgScoreWarningExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_avg_score_warning
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int deleteByExample(AvgScoreWarningExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_avg_score_warning
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_avg_score_warning
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int insert(AvgScoreWarning record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_avg_score_warning
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int insertSelective(AvgScoreWarning record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_avg_score_warning
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    List<AvgScoreWarning> selectByExample(AvgScoreWarningExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_avg_score_warning
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    AvgScoreWarning selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_avg_score_warning
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByExampleSelective(@Param("record") AvgScoreWarning record, @Param("example") AvgScoreWarningExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_avg_score_warning
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByExample(@Param("record") AvgScoreWarning record, @Param("example") AvgScoreWarningExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_avg_score_warning
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByPrimaryKeySelective(AvgScoreWarning record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_avg_score_warning
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByPrimaryKey(AvgScoreWarning record);
}