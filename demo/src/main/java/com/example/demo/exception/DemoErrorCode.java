package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DemoErrorCode {
	NO_DEVELOPER("�ش�Ǵ� �����ڰ� �����ϴ�"),
	DUPLICATED_MEMBER_ID("MemberId�� �ߺ��Ǵ� �����ڰ� �ֽ��ϴ�"),
	LEVEL_EXPERIENCE_YEARS_NOT_MATCHED("������ ������ ������ ���� �ʽ��ϴ�."),
	INTERNAL_SERVER_ERROR("������ ������ �߻��߽��ϴ�."),
	INVALID_REQUEST("�߸��� �����Դϴ�.")
	
	;
	
	private final String message;
}
