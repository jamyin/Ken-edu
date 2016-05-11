package com.ssic.education.common.mapper;

import com.ssic.education.common.pojo.MenuType;
import com.ssic.education.common.pojo.MenuTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu_type
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int countByExample(MenuTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu_type
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int deleteByExample(MenuTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu_type
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu_type
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int insert(MenuType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu_type
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int insertSelective(MenuType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu_type
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    List<MenuType> selectByExample(MenuTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu_type
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    MenuType selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu_type
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int updateByExampleSelective(@Param("record") MenuType record, @Param("example") MenuTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu_type
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int updateByExample(@Param("record") MenuType record, @Param("example") MenuTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu_type
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int updateByPrimaryKeySelective(MenuType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_admin_menu_type
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int updateByPrimaryKey(MenuType record);
}