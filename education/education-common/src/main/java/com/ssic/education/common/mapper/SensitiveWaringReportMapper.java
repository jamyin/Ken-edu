package com.ssic.education.common.mapper;

import com.ssic.education.common.pojo.SensitiveWaringReport;
import com.ssic.education.common.pojo.SensitiveWaringReportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SensitiveWaringReportMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_sensitive_waring_report
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int countByExample(SensitiveWaringReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_sensitive_waring_report
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int deleteByExample(SensitiveWaringReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_sensitive_waring_report
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_sensitive_waring_report
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int insert(SensitiveWaringReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_sensitive_waring_report
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int insertSelective(SensitiveWaringReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_sensitive_waring_report
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    List<SensitiveWaringReport> selectByExample(SensitiveWaringReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_sensitive_waring_report
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    SensitiveWaringReport selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_sensitive_waring_report
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByExampleSelective(@Param("record") SensitiveWaringReport record, @Param("example") SensitiveWaringReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_sensitive_waring_report
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByExample(@Param("record") SensitiveWaringReport record, @Param("example") SensitiveWaringReportExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_sensitive_waring_report
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByPrimaryKeySelective(SensitiveWaringReport record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_sensitive_waring_report
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByPrimaryKey(SensitiveWaringReport record);
}