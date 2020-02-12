package com.ibm.fsd.casestudy.mod.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.fsd.casestudy.mod.jpa.entity.Technology;

@Transactional
public interface TechnologyRepository extends JpaRepository<Technology, Integer> {

	@Query("SELECT t FROM Technology t")
	List<Technology> findAll();
	
	@Query("SELECT t FROM Technology t WHERE t.id = ?1")
	List<Technology> findByIdentity(Integer id);
	
	@Modifying
	@Query(value = "insert into technologies (name, duration, cost) values "
		+ "(:name, :duration, :cost)", nativeQuery = true)
	void insertTechnology(@Param("name") String name, @Param("duration") Integer duration,
					@Param("cost") Integer cost);

}
