package com.ssic.education.common.mapper;

import com.ssic.education.common.pojo.School;
import com.ssic.education.common.pojo.SchoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SchoolMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Fri Apr 01 15:30:03 CST 2016
     */
    int countByExample(SchoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Fri Apr 01 15:30:03 CST 2016
     */
    int deleteByExample(SchoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Fri Apr 01 15:30:03 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Fri Apr 01 15:30:03 CST 2016
     */
    int insert(School record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Fri Apr 01 15:30:03 CST 2016
     */
    int insertSelective(School record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Fri Apr 01 15:30:03 CST 2016
     */
    List<School> selectByExample(SchoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Fri Apr 01 15:30:03 CST 2016
     */
    School selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Fri Apr 01 15:30:03 CST 2016
     */
    int updateByExampleSelective(@Param("record") School record, @Param("example") SchoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Fri Apr 01 15:30:03 CST 2016
     */
    int updateByExample(@Param("record") School record, @Param("example") SchoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Fri Apr 01 15:30:03 CST 2016
     */
    int updateByPrimaryKeySelective(School record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Fri Apr 01 15:30:03 CST 2016
     */
    int updateByPrimaryKey(School record);
}