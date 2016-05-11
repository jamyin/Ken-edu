package com.ssic.education.common.mapper;

import com.ssic.education.common.pojo.ProPractitioners;
import com.ssic.education.common.pojo.ProPractitionersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProPractitionersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_practitioners
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    int countByExample(ProPractitionersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_practitioners
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    int deleteByExample(ProPractitionersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_practitioners
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_practitioners
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    int insert(ProPractitioners record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_practitioners
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    int insertSelective(ProPractitioners record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_practitioners
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    List<ProPractitioners> selectByExample(ProPractitionersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_practitioners
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    ProPractitioners selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_practitioners
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    int updateByExampleSelective(@Param("record") ProPractitioners record, @Param("example") ProPractitionersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_practitioners
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    int updateByExample(@Param("record") ProPractitioners record, @Param("example") ProPractitionersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_practitioners
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    int updateByPrimaryKeySelective(ProPractitioners record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_practitioners
     *
     * @mbggenerated Wed May 11 10:54:36 CST 2016
     */
    int updateByPrimaryKey(ProPractitioners record);
}