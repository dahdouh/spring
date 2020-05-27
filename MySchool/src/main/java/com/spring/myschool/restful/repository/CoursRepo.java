package com.spring.myschool.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.myschool.restful.model.Course;


@Repository
public interface CoursRepo extends CrudRepository<Course, Integer>, JpaRepository<Course, Integer> {

	@Transactional
	@Modifying
	@Query("update Course u set u.progress = :progress where u.id = :id")
	void updateSynch(@Param("id") int id, @Param("progress") String progress);
}
