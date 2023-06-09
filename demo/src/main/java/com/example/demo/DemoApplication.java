package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


//@EnableJpaAuditing : Entity 영속성객체내부에 시작일자,수정일자를 자동바인딩시켜준다.
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
