package com.example.demo.dto;

import com.example.demo.entity.Developer;
import com.example.demo.type.DeveloperLevel;
import com.example.demo.type.DeveloperSkillType;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class CreateDeveloper {
	
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	@ToString
	public static class Request {
		
		@NotNull
		private DeveloperLevel developerLevel;
		@NotNull
		private DeveloperSkillType developerSkillType;
		
		@NotNull
		@Min(0)
		@Max(20)
		private Integer experienceYears;
		
		@NotNull
		@Size(min = 3 , max = 50 , message = "memberId size nust 3~50")
		private String memberId;
		@NotNull
		@Size(min = 3 , max = 20 , message = "name size nust 3~20")
		private String name;		
		@Min(18)
		private Integer age;
		
	}
	
	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	@Builder
	public static class Responese {
		private DeveloperLevel developerLevel;
		private DeveloperSkillType developerSkillType;
		private Integer experienceYears;
		
		private String memberId;
		private String name;
		private Integer age;
		
		public static Responese fromEntity(Developer developer) {
			return Responese.builder()
					.developerLevel(developer.getDeveloperLevel())
					.developerSkillType(developer.getDeveloperSkillType())
					.experienceYears(developer.getExperienceYears())
					.memberId(developer.getMemberId())
					.name(developer.getName())
					.age(developer.getAge())
					.build();
		}
		
	}
}
