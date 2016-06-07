package com.ssic.education.handle.mapper;

import com.ssic.education.handle.pojo.ProLedgerMaster;
import com.ssic.education.handle.pojo.ProLedgerMasterExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProLedgerMasterMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_ledger_master
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int countByExample(ProLedgerMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_ledger_master
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int deleteByExample(ProLedgerMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_ledger_master
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_ledger_master
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int insert(ProLedgerMaster record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_ledger_master
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int insertSelective(ProLedgerMaster record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_ledger_master
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    List<ProLedgerMaster> selectByExample(ProLedgerMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_ledger_master
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    ProLedgerMaster selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_ledger_master
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int updateByExampleSelective(@Param("record") ProLedgerMaster record, @Param("example") ProLedgerMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_ledger_master
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int updateByExample(@Param("record") ProLedgerMaster record, @Param("example") ProLedgerMasterExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_ledger_master
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int updateByPrimaryKeySelective(ProLedgerMaster record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_pro_ledger_master
     *
     * @mbggenerated Tue Jun 07 10:44:38 CST 2016
     */
    int updateByPrimaryKey(ProLedgerMaster record);
}