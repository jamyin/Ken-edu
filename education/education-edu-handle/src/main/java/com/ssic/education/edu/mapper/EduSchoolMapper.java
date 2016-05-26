package com.ssic.education.edu.mapper;

import com.ssic.education.edu.pojo.EduSchool;
import com.ssic.education.edu.pojo.EduSchoolExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EduSchoolMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int countByExample(EduSchoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int deleteByExample(EduSchoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int insert(EduSchool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int insertSelective(EduSchool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    List<EduSchool> selectByExample(EduSchoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    EduSchool selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int updateByExampleSelective(@Param("record") EduSchool record, @Param("example") EduSchoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int updateByExample(@Param("record") EduSchool record, @Param("example") EduSchoolExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int updateByPrimaryKeySelective(EduSchool record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_school
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int updateByPrimaryKey(EduSchool record);
}