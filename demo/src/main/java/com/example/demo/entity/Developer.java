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
//Entity������Ʈ �ش� Ŭ������ Database��ü�� ����ȭ�ϰڴ��ϴ� ��� , JPA ���
@Entity
//main�� �߰��� @EnableJpaAuditing�� �ش� Entity�� ��Ͻ�Ű�� ��� ,����,�������� �ڵ��������
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
	
	//�������ھ�����̼� : Spring Main�� @EnableJpaAuditing�� �����ؾ߾� ���ε��ȴ�.
	@CreatedDate
	private LocalDateTime createdAt;
	
	//�������ھ�����̼� : Spring Main�� @EnableJpaAuditing�� �����ؾ߾� ���ε��ȴ�.
	@LastModifiedDate
	private LocalDateTime updatedAt;
	
	
	
}
