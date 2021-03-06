package com.ssic.education.handle.mapper;

import com.ssic.education.handle.pojo.EduParentScCh;
import com.ssic.education.handle.pojo.EduParentScChExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EduParentScChMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_parent_sc_ch
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int countByExample(EduParentScChExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_parent_sc_ch
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int deleteByExample(EduParentScChExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_parent_sc_ch
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_parent_sc_ch
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int insert(EduParentScCh record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_parent_sc_ch
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int insertSelective(EduParentScCh record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_parent_sc_ch
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    List<EduParentScCh> selectByExample(EduParentScChExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_parent_sc_ch
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    EduParentScCh selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_parent_sc_ch
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int updateByExampleSelective(@Param("record") EduParentScCh record, @Param("example") EduParentScChExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_parent_sc_ch
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int updateByExample(@Param("record") EduParentScCh record, @Param("example") EduParentScChExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_parent_sc_ch
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int updateByPrimaryKeySelective(EduParentScCh record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_parent_sc_ch
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int updateByPrimaryKey(EduParentScCh record);
}