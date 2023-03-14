package com.example.demo.exception;

import lombok.Getter;

@Getter
public class DemoException extends RuntimeException {
	private DemoErrorCode demoErrorCode;
	private String detailMessage;
	
	public DemoException(DemoErrorCode demoErrorCode) {
		super(demoErrorCode.getMessage());
		this.demoErrorCode = demoErrorCode;
		this.detailMessage = demoErrorCode.getMessage();
		
	}
	
	public DemoException(DemoErrorCode demoErrorCode, String detailMessage) {
		super(detailMessage);
		this.demoErrorCode = demoErrorCode;
		this.detailMessage = demoErrorCode.getMessage();
	}
}
