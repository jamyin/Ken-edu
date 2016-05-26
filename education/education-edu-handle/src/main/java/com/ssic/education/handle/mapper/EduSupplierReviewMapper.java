package com.ssic.education.handle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.handle.pojo.EduSupplierReview;
import com.ssic.education.handle.pojo.EduSupplierReviewExample;
import com.ssic.education.handle.pojo.EduSupplierReviewKey;

public interface EduSupplierReviewMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_review
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int countByExample(EduSupplierReviewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_review
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int deleteByExample(EduSupplierReviewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_review
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int deleteByPrimaryKey(EduSupplierReviewKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_review
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int insert(EduSupplierReview record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_review
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int insertSelective(EduSupplierReview record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_review
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    List<EduSupplierReview> selectByExample(EduSupplierReviewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_review
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    EduSupplierReview selectByPrimaryKey(EduSupplierReviewKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_review
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int updateByExampleSelective(@Param("record") EduSupplierReview record, @Param("example") EduSupplierReviewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_review
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int updateByExample(@Param("record") EduSupplierReview record, @Param("example") EduSupplierReviewExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_review
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int updateByPrimaryKeySelective(EduSupplierReview record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_supplier_review
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int updateByPrimaryKey(EduSupplierReview record);
}