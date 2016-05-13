package com.ssic.education.common.mapper;

import com.ssic.education.common.pojo.ViewProSupplier;
import com.ssic.education.common.pojo.ViewProSupplierExample;
import com.ssic.education.common.pojo.ViewProSupplierWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ViewProSupplierMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_sup_sch_area_group
     *
     * @mbggenerated Fri May 13 11:46:57 CST 2016
     */
    int countByExample(ViewProSupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_sup_sch_area_group
     *
     * @mbggenerated Fri May 13 11:46:57 CST 2016
     */
    int deleteByExample(ViewProSupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_sup_sch_area_group
     *
     * @mbggenerated Fri May 13 11:46:57 CST 2016
     */
    int insert(ViewProSupplierWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_sup_sch_area_group
     *
     * @mbggenerated Fri May 13 11:46:57 CST 2016
     */
    int insertSelective(ViewProSupplierWithBLOBs record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_sup_sch_area_group
     *
     * @mbggenerated Fri May 13 11:46:57 CST 2016
     */
    List<ViewProSupplierWithBLOBs> selectByExampleWithBLOBs(ViewProSupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_sup_sch_area_group
     *
     * @mbggenerated Fri May 13 11:46:57 CST 2016
     */
    List<ViewProSupplier> selectByExample(ViewProSupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_sup_sch_area_group
     *
     * @mbggenerated Fri May 13 11:46:57 CST 2016
     */
    int updateByExampleSelective(@Param("record") ViewProSupplierWithBLOBs record, @Param("example") ViewProSupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_sup_sch_area_group
     *
     * @mbggenerated Fri May 13 11:46:57 CST 2016
     */
    int updateByExampleWithBLOBs(@Param("record") ViewProSupplierWithBLOBs record, @Param("example") ViewProSupplierExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table v_sup_sch_area_group
     *
     * @mbggenerated Fri May 13 11:46:57 CST 2016
     */
    int updateByExample(@Param("record") ViewProSupplier record, @Param("example") ViewProSupplierExample example);
}