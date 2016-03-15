package com.ssic.education.common.mapper;

import com.ssic.education.common.pojo.Guardian;
import com.ssic.education.common.pojo.GuardianExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GuardianMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_guardian
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int countByExample(GuardianExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_guardian
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int deleteByExample(GuardianExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_guardian
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_guardian
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int insert(Guardian record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_guardian
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int insertSelective(Guardian record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_guardian
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    List<Guardian> selectByExample(GuardianExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_guardian
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    Guardian selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_guardian
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByExampleSelective(@Param("record") Guardian record, @Param("example") GuardianExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_guardian
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByExample(@Param("record") Guardian record, @Param("example") GuardianExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_guardian
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByPrimaryKeySelective(Guardian record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_guardian
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByPrimaryKey(Guardian record);
}