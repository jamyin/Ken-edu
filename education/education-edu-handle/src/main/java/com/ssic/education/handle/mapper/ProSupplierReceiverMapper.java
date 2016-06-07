package com.ssic.education.handle.mapper;

import com.ssic.education.handle.pojo.ProSupplierReceiver;
import com.ssic.education.handle.pojo.ProSupplierReceiverExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProSupplierReceiverMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_supplier_receiver
     *
     * @mbggenerated Tue Jun 07 16:02:25 CST 2016
     */
    int countByExample(ProSupplierReceiverExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_supplier_receiver
     *
     * @mbggenerated Tue Jun 07 16:02:25 CST 2016
     */
    int deleteByExample(ProSupplierReceiverExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_supplier_receiver
     *
     * @mbggenerated Tue Jun 07 16:02:25 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_supplier_receiver
     *
     * @mbggenerated Tue Jun 07 16:02:25 CST 2016
     */
    int insert(ProSupplierReceiver record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_supplier_receiver
     *
     * @mbggenerated Tue Jun 07 16:02:25 CST 2016
     */
    int insertSelective(ProSupplierReceiver record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_supplier_receiver
     *
     * @mbggenerated Tue Jun 07 16:02:25 CST 2016
     */
    List<ProSupplierReceiver> selectByExample(ProSupplierReceiverExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_supplier_receiver
     *
     * @mbggenerated Tue Jun 07 16:02:25 CST 2016
     */
    ProSupplierReceiver selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_supplier_receiver
     *
     * @mbggenerated Tue Jun 07 16:02:25 CST 2016
     */
    int updateByExampleSelective(@Param("record") ProSupplierReceiver record, @Param("example") ProSupplierReceiverExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_supplier_receiver
     *
     * @mbggenerated Tue Jun 07 16:02:25 CST 2016
     */
    int updateByExample(@Param("record") ProSupplierReceiver record, @Param("example") ProSupplierReceiverExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_supplier_receiver
     *
     * @mbggenerated Tue Jun 07 16:02:25 CST 2016
     */
    int updateByPrimaryKeySelective(ProSupplierReceiver record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_supplier_receiver
     *
     * @mbggenerated Tue Jun 07 16:02:25 CST 2016
     */
    int updateByPrimaryKey(ProSupplierReceiver record);
}