package com.ssic.education.handle.mapper;

import com.ssic.education.handle.pojo.EduCanteen;
import com.ssic.education.handle.pojo.EduCanteenExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EduCanteenMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_canteen
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int countByExample(EduCanteenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_canteen
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int deleteByExample(EduCanteenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_canteen
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_canteen
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int insert(EduCanteen record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_canteen
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int insertSelective(EduCanteen record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_canteen
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    List<EduCanteen> selectByExample(EduCanteenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_canteen
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    EduCanteen selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_canteen
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int updateByExampleSelective(@Param("record") EduCanteen record, @Param("example") EduCanteenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_canteen
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int updateByExample(@Param("record") EduCanteen record, @Param("example") EduCanteenExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_canteen
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int updateByPrimaryKeySelective(EduCanteen record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_canteen
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int updateByPrimaryKey(EduCanteen record);
}