package com.spring.myschool.restful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.myschool.restful.model.Profile;

public interface ProfileRepository extends CrudRepository<Profile, Integer>, JpaRepository<Profile, Integer>{
	
	@Query("SELECT p FROM Profile p WHERE p.id = :id")
	Profile getProfileById(@Param("id") int id);
	
	@Query("SELECT p FROM Profile p WHERE p.role = :role")
	Profile getProfileByRole(@Param("role") String role);
	
	@Query("SELECT p FROM Profile p")
	List<Profile> getProfiles();

	
}
