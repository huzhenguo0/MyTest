package com.entity;
 
public enum TypeEnum {
	VIDEO(1), AUDIO(2), TEXT(3), IMAGE(4);
	
	int value;
	
	TypeEnum(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return value;
	}
}
