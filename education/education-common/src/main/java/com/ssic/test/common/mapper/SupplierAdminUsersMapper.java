package com.ssic.test.common.mapper;

import com.ssic.test.common.pojo.SupplierAdminUsers;
import com.ssic.test.common.pojo.SupplierAdminUsersExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SupplierAdminUsersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_admin_users
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int countByExample(SupplierAdminUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_admin_users
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int deleteByExample(SupplierAdminUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_admin_users
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_admin_users
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int insert(SupplierAdminUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_admin_users
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int insertSelective(SupplierAdminUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_admin_users
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    List<SupplierAdminUsers> selectByExample(SupplierAdminUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_admin_users
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    SupplierAdminUsers selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_admin_users
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByExampleSelective(@Param("record") SupplierAdminUsers record, @Param("example") SupplierAdminUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_admin_users
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByExample(@Param("record") SupplierAdminUsers record, @Param("example") SupplierAdminUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_admin_users
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByPrimaryKeySelective(SupplierAdminUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_admin_users
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByPrimaryKey(SupplierAdminUsers record);
}