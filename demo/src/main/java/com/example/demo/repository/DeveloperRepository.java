package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Developer;
//JPA Repository�� ��ӹ޴´�. �⺻���� CRUD ����� ž���Ǿ�����. =JPA ���
@Repository
public interface DeveloperRepository extends JpaRepository<Developer, Long>{
	Optional<Developer> findByMemberId(String memberId);
}
