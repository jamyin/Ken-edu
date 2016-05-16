package com.ssic.education.common.mapper;

import com.ssic.education.common.pojo.ProLicense;
import com.ssic.education.common.pojo.ProLicenseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProLicenseMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    int countByExample(ProLicenseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    int deleteByExample(ProLicenseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    int insert(ProLicense record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    int insertSelective(ProLicense record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    List<ProLicense> selectByExample(ProLicenseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    ProLicense selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    int updateByExampleSelective(@Param("record") ProLicense record, @Param("example") ProLicenseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    int updateByExample(@Param("record") ProLicense record, @Param("example") ProLicenseExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    int updateByPrimaryKeySelective(ProLicense record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_license
     *
     * @mbggenerated Mon May 16 10:22:46 CST 2016
     */
    int updateByPrimaryKey(ProLicense record);
}