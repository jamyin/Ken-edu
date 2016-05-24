package com.ssic.education.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ssic.education.app.dto.LedgerInfoDto;
import com.ssic.education.app.dto.LedgerListDto;

/**
 * 		
 * <p>Title: LedgerInfoExMapper </p>
 * <p>Description: 分类帐Mapper类</p>
 * <p>Copyright (c) 2016 </p>
 * <p>Company: 上海天坊信息科技有限公司</p>
 * @author SeanYoung
 * @date 2016年5月17日 上午10:46:16	
 * @version 1.0
 * <p>修改人：SeanYoung</p>
 * <p>修改时间：2016年5月17日 上午10:46:16</p>
 * <p>修改备注：</p>
 */
public interface LedgerInfoExMapper {
	LedgerInfoDto findLedgerByBatchNo(@Param("batchNo") String batchNo);

	List<LedgerListDto> findLedgerByWaresId(@Param("waresId") String waresId);
}