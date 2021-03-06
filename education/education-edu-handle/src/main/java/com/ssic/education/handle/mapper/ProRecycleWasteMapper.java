package com.ssic.education.handle.mapper;

import com.ssic.education.handle.pojo.ProRecycleWaste;
import com.ssic.education.handle.pojo.ProRecycleWasteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProRecycleWasteMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_waste
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int countByExample(ProRecycleWasteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_waste
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int deleteByExample(ProRecycleWasteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_waste
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_waste
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int insert(ProRecycleWaste record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_waste
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int insertSelective(ProRecycleWaste record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_waste
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    List<ProRecycleWaste> selectByExample(ProRecycleWasteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_waste
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    ProRecycleWaste selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_waste
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int updateByExampleSelective(@Param("record") ProRecycleWaste record, @Param("example") ProRecycleWasteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_waste
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int updateByExample(@Param("record") ProRecycleWaste record, @Param("example") ProRecycleWasteExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_waste
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int updateByPrimaryKeySelective(ProRecycleWaste record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_recycle_waste
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int updateByPrimaryKey(ProRecycleWaste record);
}