package com.example.demo.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DeveloperLevel {
	NEW("���԰�����"),
	JUNIOR("�ʱް�����"),
	JINGNIOR("�߰�������"),
	SENIOR("��ް�����");
	
	private final String discription;
}
