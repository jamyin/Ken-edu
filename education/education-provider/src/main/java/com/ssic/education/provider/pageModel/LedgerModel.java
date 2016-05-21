package com.ssic.education.provider.pageModel;

import java.util.List;

import com.ssic.education.provider.dto.LedgerDto;


public class LedgerModel implements java.io.Serializable {

    private List<LedgerDto> ledger;

    public List<LedgerDto> getLedger() {
        return ledger;
    }

    public void setLedger(List<LedgerDto> ledger) {
        this.ledger = ledger;
    }

    public LedgerModel(List<LedgerDto> ledger) {
        super();
        this.ledger = ledger;
    }

    public LedgerModel() {
        super();
    }

	@Override
	public String toString() {
		return "LedgerModel [ledger=" + ledger + "]";
	}

    
    
}
