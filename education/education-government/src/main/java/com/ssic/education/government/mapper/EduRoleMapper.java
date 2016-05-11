package com.ssic.education.government.mapper;

import com.ssic.education.government.pojo.EduRole;
import com.ssic.education.government.pojo.EduRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EduRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    int countByExample(EduRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    int deleteByExample(EduRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    int insert(EduRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    int insertSelective(EduRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    List<EduRole> selectByExample(EduRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    EduRole selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    int updateByExampleSelective(@Param("record") EduRole record, @Param("example") EduRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    int updateByExample(@Param("record") EduRole record, @Param("example") EduRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    int updateByPrimaryKeySelective(EduRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    int updateByPrimaryKey(EduRole record);
}