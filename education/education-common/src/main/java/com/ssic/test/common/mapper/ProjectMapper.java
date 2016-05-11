package com.ssic.test.common.mapper;

import com.ssic.test.common.pojo.Project;
import com.ssic.test.common.pojo.ProjectExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface ProjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_project
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int countByExample(ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_project
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int deleteByExample(ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_project
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_project
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int insert(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_project
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int insertSelective(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_project
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    List<Project> selectByExample(ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_project
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    Project selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_project
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByExampleSelective(@Param("record") Project record, @Param("example") ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_project
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByExample(@Param("record") Project record, @Param("example") ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_project
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByPrimaryKeySelective(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_project
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByPrimaryKey(Project record);
}