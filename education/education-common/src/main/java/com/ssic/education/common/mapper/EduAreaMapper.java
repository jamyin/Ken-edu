package com.ssic.education.common.mapper;

import com.ssic.education.common.pojo.EduArea;
import com.ssic.education.common.pojo.EduAreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EduAreaMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_area
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    int countByExample(EduAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_area
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    int deleteByExample(EduAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_area
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_area
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    int insert(EduArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_area
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    int insertSelective(EduArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_area
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    List<EduArea> selectByExample(EduAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_area
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    EduArea selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_area
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    int updateByExampleSelective(@Param("record") EduArea record, @Param("example") EduAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_area
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    int updateByExample(@Param("record") EduArea record, @Param("example") EduAreaExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_area
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    int updateByPrimaryKeySelective(EduArea record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_area
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    int updateByPrimaryKey(EduArea record);
}