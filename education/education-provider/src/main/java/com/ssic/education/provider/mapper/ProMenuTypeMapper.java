package com.ssic.education.provider.mapper;

import com.ssic.education.provider.pojo.ProMenuType;
import com.ssic.education.provider.pojo.ProMenuTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProMenuTypeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_admin_menu_type
     *
     * @mbggenerated Wed May 11 11:05:19 CST 2016
     */
    int countByExample(ProMenuTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_admin_menu_type
     *
     * @mbggenerated Wed May 11 11:05:19 CST 2016
     */
    int deleteByExample(ProMenuTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_admin_menu_type
     *
     * @mbggenerated Wed May 11 11:05:19 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_admin_menu_type
     *
     * @mbggenerated Wed May 11 11:05:19 CST 2016
     */
    int insert(ProMenuType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_admin_menu_type
     *
     * @mbggenerated Wed May 11 11:05:19 CST 2016
     */
    int insertSelective(ProMenuType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_admin_menu_type
     *
     * @mbggenerated Wed May 11 11:05:19 CST 2016
     */
    List<ProMenuType> selectByExample(ProMenuTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_admin_menu_type
     *
     * @mbggenerated Wed May 11 11:05:19 CST 2016
     */
    ProMenuType selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_admin_menu_type
     *
     * @mbggenerated Wed May 11 11:05:19 CST 2016
     */
    int updateByExampleSelective(@Param("record") ProMenuType record, @Param("example") ProMenuTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_admin_menu_type
     *
     * @mbggenerated Wed May 11 11:05:19 CST 2016
     */
    int updateByExample(@Param("record") ProMenuType record, @Param("example") ProMenuTypeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_admin_menu_type
     *
     * @mbggenerated Wed May 11 11:05:19 CST 2016
     */
    int updateByPrimaryKeySelective(ProMenuType record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_admin_menu_type
     *
     * @mbggenerated Wed May 11 11:05:19 CST 2016
     */
    int updateByPrimaryKey(ProMenuType record);
}