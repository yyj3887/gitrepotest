package com.example.demo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.example.demo.type.DeveloperLevel;
import com.example.demo.type.DeveloperSkillType;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//Entity컴포넌트 해당 클레스를 Database객체로 영속화하겠다하는 기능 , JPA 기능
@Entity
//main에 추가한 @EnableJpaAuditing에 해당 Entity를 등록시키는 기능 ,생성,수정일자 자동생성기능
@EntityListeners(AuditingEntityListener.class) 
public class Developer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	@Enumerated(EnumType.STRING)
	private DeveloperLevel developerLevel;
	
	@Enumerated(EnumType.STRING)
	private DeveloperSkillType developerSkillType;
	
	private Integer experienceYears;
	private String memberId;
	private String name;
	private Integer age;
	
	//생성일자어노테이션 : Spring Main에 @EnableJpaAuditing를 선언해야야 바인딩된다.
	@CreatedDate
	private LocalDateTime createdAt;
	
	//수정일자어노테이션 : Spring Main에 @EnableJpaAuditing를 선언해야야 바인딩된다.
	@LastModifiedDate
	private LocalDateTime updatedAt;
	
	
	
}
