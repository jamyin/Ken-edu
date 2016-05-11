package com.ssic.education.common.mapper;

import com.ssic.education.common.pojo.UserRole;
import com.ssic.education.common.pojo.UserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_users_role
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int countByExample(UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_users_role
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int deleteByExample(UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_users_role
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_users_role
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int insert(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_users_role
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int insertSelective(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_users_role
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    List<UserRole> selectByExample(UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_users_role
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    UserRole selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_users_role
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_users_role
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_users_role
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int updateByPrimaryKeySelective(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_users_role
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int updateByPrimaryKey(UserRole record);
}