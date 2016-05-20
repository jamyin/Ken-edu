package com.ssic.education.common.mapper;

import com.ssic.education.common.pojo.ProPackages;
import com.ssic.education.common.pojo.ProPackagesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProPackagesMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_packages
     *
     * @mbggenerated Fri May 20 10:11:49 CST 2016
     */
    int countByExample(ProPackagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_packages
     *
     * @mbggenerated Fri May 20 10:11:49 CST 2016
     */
    int deleteByExample(ProPackagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_packages
     *
     * @mbggenerated Fri May 20 10:11:49 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_packages
     *
     * @mbggenerated Fri May 20 10:11:49 CST 2016
     */
    int insert(ProPackages record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_packages
     *
     * @mbggenerated Fri May 20 10:11:49 CST 2016
     */
    int insertSelective(ProPackages record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_packages
     *
     * @mbggenerated Fri May 20 10:11:49 CST 2016
     */
    List<ProPackages> selectByExample(ProPackagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_packages
     *
     * @mbggenerated Fri May 20 10:11:49 CST 2016
     */
    ProPackages selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_packages
     *
     * @mbggenerated Fri May 20 10:11:49 CST 2016
     */
    int updateByExampleSelective(@Param("record") ProPackages record, @Param("example") ProPackagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_packages
     *
     * @mbggenerated Fri May 20 10:11:49 CST 2016
     */
    int updateByExample(@Param("record") ProPackages record, @Param("example") ProPackagesExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_packages
     *
     * @mbggenerated Fri May 20 10:11:49 CST 2016
     */
    int updateByPrimaryKeySelective(ProPackages record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_packages
     *
     * @mbggenerated Fri May 20 10:11:49 CST 2016
     */
    int updateByPrimaryKey(ProPackages record);
}