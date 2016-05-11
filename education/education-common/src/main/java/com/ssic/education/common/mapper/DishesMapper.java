package com.ssic.education.common.mapper;

import com.ssic.education.common.pojo.Dishes;
import com.ssic.education.common.pojo.DishesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DishesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int countByExample(DishesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int deleteByExample(DishesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int insert(Dishes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int insertSelective(Dishes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    List<Dishes> selectByExample(DishesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    Dishes selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int updateByExampleSelective(@Param("record") Dishes record, @Param("example") DishesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int updateByExample(@Param("record") Dishes record, @Param("example") DishesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int updateByPrimaryKeySelective(Dishes record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_dishes
     *
     * @mbggenerated Wed May 11 10:07:25 CST 2016
     */
    int updateByPrimaryKey(Dishes record);
}