package br.com.starcode.finance.model;

public enum MovementType {

	Credit("C"), Debit("D");
	
	private String code;
	
	private MovementType(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public static MovementType fromCode(String code) {
		for (MovementType item : MovementType.values()) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
		return null;
	}
	
}
