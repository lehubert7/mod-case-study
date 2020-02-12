package com.ibm.fsd.casestudy.mod.jpa.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.fsd.casestudy.mod.jpa.entity.Training;

@Transactional
public interface TrainingRepository extends JpaRepository<Training, Integer> {
	
	@Query("SELECT t FROM Training t WHERE t.id = ?1")
	List<Training> findByIdentity(Integer id);
	
	@Query("SELECT t FROM Training t WHERE t.status = ?1")
	List<Training> findByStatus(String status);
	
	@Query("SELECT t FROM Training t WHERE t.scholar = ?1 and t.status = ?2")
	List<Training> findForScholarByStatus(Integer scholar, String status);
	
	@Query("SELECT t FROM Training t WHERE t.mentor = ?1 and t.status = ?2")
	List<Training> findForMentorByStatus(Integer mentor, String status);
	
	@Query("SELECT t FROM Training t WHERE t.mentor = ?1 and t.status = ?2 and t.technology = ?3")
	List<Training> findForMentorByStatusAndTechnology(Integer mentor, String status, Integer technology);
	
	@Query("SELECT t FROM Training t WHERE t.mentor = ?1 and t.scholar = ?2 and t.status = ?3 and t.technology = ?4")
	List<Training> findForMentorAndScholarByStatusAndTechnology(Integer mentor, Integer scholar, String status, Integer technology);
	
	@Modifying
	@Query(value = "insert into trainings (scholar, mentor, technology, startdate, enddate) values "
		+ "(:scholar, :mentor, :technology, :startdate, :enddate)", nativeQuery = true)
	void insertTraining(@Param("scholar") Integer scholar, @Param("mentor") Integer mentor,
					@Param("technology") Integer technology, @Param("startdate") Date startdate,
					@Param("enddate") Date enddate);
	
	@Modifying
	@Query(value = "update trainings set status = :status where id = :id", nativeQuery = true)
	void updateTrainingById(@Param("id") Integer id, @Param("status") String status);

}
