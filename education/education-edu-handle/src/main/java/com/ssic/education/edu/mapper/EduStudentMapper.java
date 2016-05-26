package com.ssic.education.edu.mapper;

import com.ssic.education.edu.pojo.EduStudent;
import com.ssic.education.edu.pojo.EduStudentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EduStudentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_student
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int countByExample(EduStudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_student
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int deleteByExample(EduStudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_student
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_student
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int insert(EduStudent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_student
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int insertSelective(EduStudent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_student
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    List<EduStudent> selectByExample(EduStudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_student
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    EduStudent selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_student
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int updateByExampleSelective(@Param("record") EduStudent record, @Param("example") EduStudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_student
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int updateByExample(@Param("record") EduStudent record, @Param("example") EduStudentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_student
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int updateByPrimaryKeySelective(EduStudent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_student
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int updateByPrimaryKey(EduStudent record);
}