package com.example.demo.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DeveloperLevel {
	NEW("신입개발자"),
	JUNIOR("초급개발자"),
	JINGNIOR("중간개발자"),
	SENIOR("고급개발자");
	
	private final String discription;
}
