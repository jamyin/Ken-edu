package com.ssic.education.handle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.handle.pojo.ProEmployee;
import com.ssic.education.handle.pojo.ProEmployeeExample;

public interface ProEmployeeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_employee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int countByExample(ProEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_employee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int deleteByExample(ProEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_employee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_employee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int insert(ProEmployee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_employee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int insertSelective(ProEmployee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_employee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    List<ProEmployee> selectByExample(ProEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_employee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    ProEmployee selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_employee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int updateByExampleSelective(@Param("record") ProEmployee record, @Param("example") ProEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_employee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int updateByExample(@Param("record") ProEmployee record, @Param("example") ProEmployeeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_employee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int updateByPrimaryKeySelective(ProEmployee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_employee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int updateByPrimaryKey(ProEmployee record);
}