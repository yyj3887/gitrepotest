package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Developer;
//JPA Repository를 상속받는다. 기본적인 CRUD 기능이 탑제되어있음. =JPA 기능
@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long>{
	Optional<Developer> findByMemberId(String memberId);
}
