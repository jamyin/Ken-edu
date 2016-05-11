package com.ssic.test.common.mapper;

import com.ssic.test.common.pojo.MaterialSupplier;
import com.ssic.test.common.pojo.MaterialSupplierExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface MaterialSupplierMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_material_supplier
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int countByExample(MaterialSupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_material_supplier
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int deleteByExample(MaterialSupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_material_supplier
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_material_supplier
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int insert(MaterialSupplier record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_material_supplier
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int insertSelective(MaterialSupplier record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_material_supplier
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    List<MaterialSupplier> selectByExample(MaterialSupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_material_supplier
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    MaterialSupplier selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_material_supplier
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByExampleSelective(@Param("record") MaterialSupplier record, @Param("example") MaterialSupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_material_supplier
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByExample(@Param("record") MaterialSupplier record, @Param("example") MaterialSupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_material_supplier
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByPrimaryKeySelective(MaterialSupplier record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_material_supplier
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByPrimaryKey(MaterialSupplier record);
}