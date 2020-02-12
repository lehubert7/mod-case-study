package com.ibm.fsd.casestudy.mod.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.fsd.casestudy.mod.jpa.entity.MentorSkill;

@Transactional
public interface MentorSkillRepository extends JpaRepository<MentorSkill, Integer> {
	
	@Query("SELECT m FROM MentorSkill m WHERE m.mentor = ?1 and m.status = ?2")
	List<MentorSkill> findByMentorId(Integer mentor, String status);
	
	@Query("SELECT m FROM MentorSkill m WHERE m.technology = ?1 and m.status = ?2")
	List<MentorSkill> findMentorByTechnology(Integer technology, String status);
	
	@Modifying
	@Query(value = "insert into mentorskills (mentor, technology, experience, status) values "
		+ "(:mentor, :technology, :experience, :status)", nativeQuery = true)
	void insertMentorSkill(@Param("mentor") Integer mentor, @Param("technology") Integer technology,
			@Param("experience") Integer experience, @Param("status") String status);
	
	@Modifying
	@Query(value = "update mentorskills set status = 'approved' where id = :id", nativeQuery = true)
	void approveMentorSkill(@Param("id") Integer id);
	
	@Modifying
	@Query(value = "update mentorskills set experience = :experience where id = :id", nativeQuery = true)
	void updateExperience(@Param("id") Integer id, @Param("experience") Integer experience);

}
