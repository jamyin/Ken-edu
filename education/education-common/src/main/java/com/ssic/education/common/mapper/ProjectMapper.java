package com.ssic.education.common.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.common.pojo.Project;
import com.ssic.education.common.pojo.ProjectExample;

public interface ProjectMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ims_project
     *
     * @mbggenerated Fri Jun 26 21:19:17 CST 2015
     */
    int countByExample(ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ims_project
     *
     * @mbggenerated Fri Jun 26 21:19:17 CST 2015
     */
    int deleteByExample(ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ims_project
     *
     * @mbggenerated Fri Jun 26 21:19:17 CST 2015
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ims_project
     *
     * @mbggenerated Fri Jun 26 21:19:17 CST 2015
     */
    int insert(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ims_project
     *
     * @mbggenerated Fri Jun 26 21:19:17 CST 2015
     */
    int insertSelective(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ims_project
     *
     * @mbggenerated Fri Jun 26 21:19:17 CST 2015
     */
    List<Project> selectByExample(ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ims_project
     *
     * @mbggenerated Fri Jun 26 21:19:17 CST 2015
     */
    Project selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ims_project
     *
     * @mbggenerated Fri Jun 26 21:19:17 CST 2015
     */
    int updateByExampleSelective(@Param("record") Project record, @Param("example") ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ims_project
     *
     * @mbggenerated Fri Jun 26 21:19:17 CST 2015
     */
    int updateByExample(@Param("record") Project record, @Param("example") ProjectExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ims_project
     *
     * @mbggenerated Fri Jun 26 21:19:17 CST 2015
     */
    int updateByPrimaryKeySelective(Project record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_ims_project
     *
     * @mbggenerated Fri Jun 26 21:19:17 CST 2015
     */
    int updateByPrimaryKey(Project record);
}