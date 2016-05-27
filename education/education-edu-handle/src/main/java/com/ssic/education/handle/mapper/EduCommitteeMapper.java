package com.ssic.education.handle.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.handle.pojo.EduCommittee;
import com.ssic.education.handle.pojo.EduCommitteeExample;

public interface EduCommitteeMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_committee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int countByExample(EduCommitteeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_committee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int deleteByExample(EduCommitteeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_committee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_committee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int insert(EduCommittee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_committee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int insertSelective(EduCommittee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_committee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    List<EduCommittee> selectByExample(EduCommitteeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_committee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    EduCommittee selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_committee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int updateByExampleSelective(@Param("record") EduCommittee record, @Param("example") EduCommitteeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_committee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int updateByExample(@Param("record") EduCommittee record, @Param("example") EduCommitteeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_committee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int updateByPrimaryKeySelective(EduCommittee record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_committee
     *
     * @mbggenerated Thu May 26 19:23:18 CST 2016
     */
    int updateByPrimaryKey(EduCommittee record);
}