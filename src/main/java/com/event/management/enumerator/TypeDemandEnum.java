package com.event.management.enumerator;

public enum TypeDemandEnum {
	
	CCFS("Campus Catering Full Service"),
	CCE("Campus Catering Express"),
	KWE("KW Express"),
	KWFS("KW Full Service");

    private final String description;

    TypeDemandEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

}
