package com.ssic.education.common.mapper;

import com.ssic.education.common.pojo.Address;
import com.ssic.education.common.pojo.AddressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AddressMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_address
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int countByExample(AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_address
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int deleteByExample(AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_address
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_address
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int insert(Address record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_address
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int insertSelective(Address record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_address
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    List<Address> selectByExample(AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_address
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    Address selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_address
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByExampleSelective(@Param("record") Address record, @Param("example") AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_address
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByExample(@Param("record") Address record, @Param("example") AddressExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_address
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByPrimaryKeySelective(Address record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_edu_address
     *
     * @mbggenerated Tue Mar 15 11:16:51 CST 2016
     */
    int updateByPrimaryKey(Address record);
}