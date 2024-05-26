package com.masantello.demo.models.enums;

public enum Language {

	PORTUGUESE(0, "Portuguese"), ENGLISH(1, "English"), SPANISH(2, "Spanish"), ITALIAN(3, "Italian");

	private Integer code;
	private String description;

	private Language() {

	}

	private Language(Integer code, String description) {
		this.code = code;
		this.description = description;
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static Language toEnum(Integer code) {
		if (code == null) {
			return null;
		}

		for (Language lang : Language.values()) {
			if (lang.getCode() == code) {
				return lang;
			}
		}

		throw new IllegalArgumentException("Invalid language! " + code);
	}
	
}
