package com.ssic.education.handle.service;

import java.util.List;

import com.ssic.educateion.common.dto.ProLedgerMasterDto;

public interface IProLedgerMasterService {
	List<ProLedgerMasterDto> searchProLedgerMasterDto(ProLedgerMasterDto proLedgerMasterDto);

	ProLedgerMasterDto searchProLedgerMasterDto(String masterId);
}
