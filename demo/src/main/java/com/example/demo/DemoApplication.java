package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


//@EnableJpaAuditing : Entity ���Ӽ���ü���ο� ��������,�������ڸ� �ڵ����ε������ش�.
@EnableJpaAuditing
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		String a = "12330";
		String b = "1";
		String c = "2";
		String d = "3";
		String d1 = "31";
	}

}
