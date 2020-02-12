package com.ibm.fsd.casestudy.mod.jpa.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ibm.fsd.casestudy.mod.jpa.entity.User;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("SELECT u FROM User u WHERE u.id = ?1")
	List<User> findByIdentity(Integer id);
	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	List<User> findByEmail(String email);
	
	@Modifying
	@Query(value = "insert into Users (name, email, password, usertype, location) values "
		+ "(:name, :email, :password, :usertype, :location)", nativeQuery = true)
	void insertUser(@Param("name") String name, @Param("email") String email,
					@Param("password") String password, @Param("usertype") String usertype,
					@Param("location") String location);

}
