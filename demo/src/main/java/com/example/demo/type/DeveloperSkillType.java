package com.example.demo.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DeveloperSkillType {
	FRONT("프론트"),
	BACKEND("백엔드"),
	FULLSTACK("풀스택");	
	private final String discription;
}
