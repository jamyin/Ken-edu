package com.ssic.education.edu.mapper;

import com.ssic.education.edu.pojo.EduInformation;
import com.ssic.education.edu.pojo.EduInformationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EduInformationMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_information
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int countByExample(EduInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_information
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int deleteByExample(EduInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_information
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_information
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int insert(EduInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_information
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int insertSelective(EduInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_information
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    List<EduInformation> selectByExampleWithBLOBs(EduInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_information
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    List<EduInformation> selectByExample(EduInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_information
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    EduInformation selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_information
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int updateByExampleSelective(@Param("record") EduInformation record, @Param("example") EduInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_information
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int updateByExampleWithBLOBs(@Param("record") EduInformation record, @Param("example") EduInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_information
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int updateByExample(@Param("record") EduInformation record, @Param("example") EduInformationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_information
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int updateByPrimaryKeySelective(EduInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_information
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int updateByPrimaryKeyWithBLOBs(EduInformation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_information
     *
     * @mbggenerated Thu May 26 11:08:19 CST 2016
     */
    int updateByPrimaryKey(EduInformation record);
}