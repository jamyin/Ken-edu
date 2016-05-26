package com.ssic.education.pro.mapper;

import com.ssic.education.pro.pojo.ProNutritional;
import com.ssic.education.pro.pojo.ProNutritionalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProNutritionalMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_nutritional
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    int countByExample(ProNutritionalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_nutritional
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    int deleteByExample(ProNutritionalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_nutritional
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_nutritional
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    int insert(ProNutritional record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_nutritional
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    int insertSelective(ProNutritional record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_nutritional
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    List<ProNutritional> selectByExample(ProNutritionalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_nutritional
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    ProNutritional selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_nutritional
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    int updateByExampleSelective(@Param("record") ProNutritional record, @Param("example") ProNutritionalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_nutritional
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    int updateByExample(@Param("record") ProNutritional record, @Param("example") ProNutritionalExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_nutritional
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    int updateByPrimaryKeySelective(ProNutritional record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_nutritional
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    int updateByPrimaryKey(ProNutritional record);
}