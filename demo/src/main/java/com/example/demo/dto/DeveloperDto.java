package com.example.demo.dto;

import com.example.demo.dto.CreateDeveloper.Responese;
import com.example.demo.entity.Developer;
import com.example.demo.type.DeveloperLevel;
import com.example.demo.type.DeveloperSkillType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class DeveloperDto {
	private DeveloperLevel developerLevel;
	private DeveloperSkillType developerSkillType;
	private Integer experienceYears;
	private String memberId;
	private String name;
	private Integer age;
	
	public static DeveloperDto fromEntity(Developer developer) {
		return DeveloperDto.builder()
				.developerLevel(developer.getDeveloperLevel())
				.developerSkillType(developer.getDeveloperSkillType())
				.experienceYears(developer.getExperienceYears())
				.memberId(developer.getMemberId())
				.name(developer.getName())
				.age(developer.getAge())
				.build();
	}
}
