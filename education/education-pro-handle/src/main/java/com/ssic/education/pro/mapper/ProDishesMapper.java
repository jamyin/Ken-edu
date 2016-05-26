package com.ssic.education.pro.mapper;

import com.ssic.education.pro.pojo.ProDishes;
import com.ssic.education.pro.pojo.ProDishesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProDishesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    int countByExample(ProDishesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    int deleteByExample(ProDishesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    int insert(ProDishes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    int insertSelective(ProDishes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    List<ProDishes> selectByExample(ProDishesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    ProDishes selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    int updateByExampleSelective(@Param("record") ProDishes record, @Param("example") ProDishesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    int updateByExample(@Param("record") ProDishes record, @Param("example") ProDishesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    int updateByPrimaryKeySelective(ProDishes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Thu May 26 11:08:24 CST 2016
     */
    int updateByPrimaryKey(ProDishes record);
}