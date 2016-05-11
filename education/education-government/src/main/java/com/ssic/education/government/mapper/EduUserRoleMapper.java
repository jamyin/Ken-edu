package com.ssic.education.government.mapper;

import com.ssic.education.government.pojo.EduUserRole;
import com.ssic.education.government.pojo.EduUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EduUserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_users_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    int countByExample(EduUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_users_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    int deleteByExample(EduUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_users_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_users_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    int insert(EduUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_users_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    int insertSelective(EduUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_users_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    List<EduUserRole> selectByExample(EduUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_users_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    EduUserRole selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_users_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    int updateByExampleSelective(@Param("record") EduUserRole record, @Param("example") EduUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_users_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    int updateByExample(@Param("record") EduUserRole record, @Param("example") EduUserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_users_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    int updateByPrimaryKeySelective(EduUserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_admin_users_role
     *
     * @mbggenerated Wed May 11 11:02:34 CST 2016
     */
    int updateByPrimaryKey(EduUserRole record);
}