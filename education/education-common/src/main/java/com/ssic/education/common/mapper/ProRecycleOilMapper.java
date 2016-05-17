package com.ssic.education.common.mapper;

import com.ssic.education.common.pojo.ProRecycleOil;
import com.ssic.education.common.pojo.ProRecycleOilExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProRecycleOilMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_oil
     *
     * @mbggenerated Mon May 16 18:56:32 CST 2016
     */
    int countByExample(ProRecycleOilExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_oil
     *
     * @mbggenerated Mon May 16 18:56:32 CST 2016
     */
    int deleteByExample(ProRecycleOilExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_oil
     *
     * @mbggenerated Mon May 16 18:56:32 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_oil
     *
     * @mbggenerated Mon May 16 18:56:32 CST 2016
     */
    int insert(ProRecycleOil record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_oil
     *
     * @mbggenerated Mon May 16 18:56:32 CST 2016
     */
    int insertSelective(ProRecycleOil record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_oil
     *
     * @mbggenerated Mon May 16 18:56:32 CST 2016
     */
    List<ProRecycleOil> selectByExample(ProRecycleOilExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_oil
     *
     * @mbggenerated Mon May 16 18:56:32 CST 2016
     */
    ProRecycleOil selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_oil
     *
     * @mbggenerated Mon May 16 18:56:32 CST 2016
     */
    int updateByExampleSelective(@Param("record") ProRecycleOil record, @Param("example") ProRecycleOilExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_oil
     *
     * @mbggenerated Mon May 16 18:56:32 CST 2016
     */
    int updateByExample(@Param("record") ProRecycleOil record, @Param("example") ProRecycleOilExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_oil
     *
     * @mbggenerated Mon May 16 18:56:32 CST 2016
     */
    int updateByPrimaryKeySelective(ProRecycleOil record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_oil
     *
     * @mbggenerated Mon May 16 18:56:32 CST 2016
     */
    int updateByPrimaryKey(ProRecycleOil record);
}