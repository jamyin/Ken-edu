package com.ssic.education.government.mapper;

import com.ssic.education.government.pojo.EduUsers;
import com.ssic.education.government.pojo.EduUsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EduUsersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_users
     *
     * @mbggenerated Sat May 21 16:57:47 CST 2016
     */
    int countByExample(EduUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_users
     *
     * @mbggenerated Sat May 21 16:57:47 CST 2016
     */
    int deleteByExample(EduUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_users
     *
     * @mbggenerated Sat May 21 16:57:47 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_users
     *
     * @mbggenerated Sat May 21 16:57:47 CST 2016
     */
    int insert(EduUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_users
     *
     * @mbggenerated Sat May 21 16:57:47 CST 2016
     */
    int insertSelective(EduUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_users
     *
     * @mbggenerated Sat May 21 16:57:47 CST 2016
     */
    List<EduUsers> selectByExample(EduUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_users
     *
     * @mbggenerated Sat May 21 16:57:47 CST 2016
     */
    EduUsers selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_users
     *
     * @mbggenerated Sat May 21 16:57:47 CST 2016
     */
    int updateByExampleSelective(@Param("record") EduUsers record, @Param("example") EduUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_users
     *
     * @mbggenerated Sat May 21 16:57:47 CST 2016
     */
    int updateByExample(@Param("record") EduUsers record, @Param("example") EduUsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_users
     *
     * @mbggenerated Sat May 21 16:57:47 CST 2016
     */
    int updateByPrimaryKeySelective(EduUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_users
     *
     * @mbggenerated Sat May 21 16:57:47 CST 2016
     */
    int updateByPrimaryKey(EduUsers record);
}