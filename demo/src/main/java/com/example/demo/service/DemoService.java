package com.example.demo.service;

import static com.example.demo.exception.DemoErrorCode.DUPLICATED_MEMBER_ID;
import static com.example.demo.exception.DemoErrorCode.LEVEL_EXPERIENCE_YEARS_NOT_MATCHED;
import static com.example.demo.exception.DemoErrorCode.NO_DEVELOPER;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.dto.CreateDeveloper;
import com.example.demo.dto.DeveloperDto;
import com.example.demo.dto.EditDeveloper;
import com.example.demo.dto.DeveloperDetailDto;
import com.example.demo.entity.Developer;
import com.example.demo.exception.DemoException;
import com.example.demo.repository.DeveloperRepository;
import com.example.demo.type.DeveloperLevel;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
//서비스 컴포넌트 
@Service
//생성사 주입 어노테이션 = 롬복기능
@RequiredArgsConstructor
public class DemoService {
	
	private final DeveloperRepository developerRepository;
	
	//트랜잭션처리기능이 포함된 어노테이션 DB작업시 성공하면 커밋하고 , 실패하면 롤백처리를 지원한다.
	@Transactional
	public CreateDeveloper.Responese createDeveloper(CreateDeveloper.Request request) {
		
		validateCreateDeleoperRequest(request);
		
		Developer developer = Developer.builder()
				.developerLevel(request.getDeveloperLevel())
				.developerSkillType(request.getDeveloperSkillType())
				.experienceYears(request.getExperienceYears())
				.memberId(request.getMemberId())
				.name(request.getName())
				.age(request.getAge())
				.build();
		
		developerRepository.save(developer);
		
		return  CreateDeveloper.Responese.fromEntity(developer);
		
	}
	
	//All Select
	public List<DeveloperDto> getAllDevelopers() {
		// TODO Auto-generated method stub
		return developerRepository.findAll().stream().map(DeveloperDto::fromEntity)
				.collect(Collectors.toList());
	}
	
	//Find Select
	public DeveloperDetailDto getDeveloperDetail(String memberId) {
		// TODO Auto-generated method stub
		return developerRepository.findByMemberId(memberId).map(DeveloperDetailDto::fromEntity)
				.orElseThrow( ()-> new DemoException(NO_DEVELOPER));	
	}
	
	//Update //PUT
	@Transactional
	public DeveloperDetailDto editDeveloper(String memberId, @Valid EditDeveloper.Request request) {
		// TODO Auto-generated method stub
		validateEditDeleoperRequest(request,memberId);
		
		Developer developer = developerRepository.
				findByMemberId(memberId).
				orElseThrow( ()-> new DemoException(NO_DEVELOPER));
		
		developer.setDeveloperLevel(request.getDeveloperLevel());
		developer.setDeveloperSkillType(request.getDeveloperSkillType());
		developer.setExperienceYears(request.getExperienceYears());
		
		return DeveloperDetailDto.fromEntity(developer);
	}
	
	private void validateCreateDeleoperRequest(CreateDeveloper.Request request) {
		
		validateDeveloperlevel(request.getDeveloperLevel(),
				request.getExperienceYears());
		
		developerRepository.findByMemberId(request.getMemberId()).
		ifPresent( developer -> {
			throw new DemoException(DUPLICATED_MEMBER_ID);
		});
		
	}
	
	private void validateEditDeleoperRequest(
			EditDeveloper.Request request ,
			String memberId) {
		
		validateDeveloperlevel(request.getDeveloperLevel()
				, request.getExperienceYears());
		
	}

	private void validateDeveloperlevel(DeveloperLevel developerLevel, Integer experienceYears) {
		if(developerLevel == DeveloperLevel.SENIOR 
				&& experienceYears < 10)
		{
			throw new DemoException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
		}
		
		if(developerLevel == DeveloperLevel.JINGNIOR 
				&& experienceYears < 4 || experienceYears > 10)
		{
			throw new DemoException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
		}
		
		if(developerLevel == DeveloperLevel.JUNIOR 
				&& experienceYears > 4 || experienceYears > 10)
		{
			throw new DemoException(LEVEL_EXPERIENCE_YEARS_NOT_MATCHED);
		}
	}

}
