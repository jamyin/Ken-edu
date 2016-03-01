package com.ssic.education.admin.mapper;

import com.ssic.education.admin.pojo.AdminMenu;
import com.ssic.education.admin.pojo.AdminMenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu
     *
     * @mbggenerated Tue Mar 01 09:19:48 CST 2016
     */
    int countByExample(AdminMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu
     *
     * @mbggenerated Tue Mar 01 09:19:48 CST 2016
     */
    int deleteByExample(AdminMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu
     *
     * @mbggenerated Tue Mar 01 09:19:48 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu
     *
     * @mbggenerated Tue Mar 01 09:19:48 CST 2016
     */
    int insert(AdminMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu
     *
     * @mbggenerated Tue Mar 01 09:19:48 CST 2016
     */
    int insertSelective(AdminMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu
     *
     * @mbggenerated Tue Mar 01 09:19:48 CST 2016
     */
    List<AdminMenu> selectByExample(AdminMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu
     *
     * @mbggenerated Tue Mar 01 09:19:48 CST 2016
     */
    AdminMenu selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu
     *
     * @mbggenerated Tue Mar 01 09:19:48 CST 2016
     */
    int updateByExampleSelective(@Param("record") AdminMenu record, @Param("example") AdminMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu
     *
     * @mbggenerated Tue Mar 01 09:19:48 CST 2016
     */
    int updateByExample(@Param("record") AdminMenu record, @Param("example") AdminMenuExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu
     *
     * @mbggenerated Tue Mar 01 09:19:48 CST 2016
     */
    int updateByPrimaryKeySelective(AdminMenu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu
     *
     * @mbggenerated Tue Mar 01 09:19:48 CST 2016
     */
    int updateByPrimaryKey(AdminMenu record);
}