package com.ssic.education.government.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.government.pojo.EduTab;
import com.ssic.education.government.pojo.EduTabExample;

public interface EduTabMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_tab
     *
     * @mbggenerated Thu May 12 14:27:54 CST 2016
     */
    int countByExample(EduTabExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_tab
     *
     * @mbggenerated Thu May 12 14:27:54 CST 2016
     */
    int deleteByExample(EduTabExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_tab
     *
     * @mbggenerated Thu May 12 14:27:54 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_tab
     *
     * @mbggenerated Thu May 12 14:27:54 CST 2016
     */
    int insert(EduTab record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_tab
     *
     * @mbggenerated Thu May 12 14:27:54 CST 2016
     */
    int insertSelective(EduTab record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_tab
     *
     * @mbggenerated Thu May 12 14:27:54 CST 2016
     */
    List<EduTab> selectByExample(EduTabExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_tab
     *
     * @mbggenerated Thu May 12 14:27:54 CST 2016
     */
    EduTab selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_tab
     *
     * @mbggenerated Thu May 12 14:27:54 CST 2016
     */
    int updateByExampleSelective(@Param("record") EduTab record, @Param("example") EduTabExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_tab
     *
     * @mbggenerated Thu May 12 14:27:54 CST 2016
     */
    int updateByExample(@Param("record") EduTab record, @Param("example") EduTabExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_tab
     *
     * @mbggenerated Thu May 12 14:27:54 CST 2016
     */
    int updateByPrimaryKeySelective(EduTab record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_tab
     *
     * @mbggenerated Thu May 12 14:27:54 CST 2016
     */
    int updateByPrimaryKey(EduTab record);
}