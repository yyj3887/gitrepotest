package com.example.demo.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DeveloperSkillType {
	FRONT("����Ʈ"),
	BACKEND("�鿣��"),
	FULLSTACK("Ǯ����");	
	private final String discription;
}
