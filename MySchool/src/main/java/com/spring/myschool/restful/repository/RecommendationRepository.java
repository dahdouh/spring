package com.spring.myschool.restful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.myschool.restful.model.Recommendation;

@Repository
public interface RecommendationRepository  extends CrudRepository<Recommendation, Integer>, JpaRepository<Recommendation, Integer> {

    //@Query(value="select e from recommendation e where empName = ?1 limit 1", nativeQuery=true)
	//@Query(value="select r.* from recommendation r limit 1", nativeQuery=true)
	@Query(value="SELECT r from Recommendation r")
	List<Recommendation> getRecommendationMsg();
}
