package com.spring.myschool.restful.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.myschool.restful.model.Compte;
import com.spring.myschool.restful.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Integer>,  JpaRepository<User, Integer> {

	 
		@Query("SELECT u FROM User u WHERE u.compte.id = :compteId")
		User getUserByCompteId(@Param("compteId") int compteId);
		
		@Query("SELECT u FROM User u WHERE u.email = :email")
		User getUserByEmail(@Param("email") String email);
		
		@Query("SELECT u FROM User u WHERE u.id = :id")
		User getUserById(@Param("id") int id);
		
		@Query("SELECT u FROM User u WHERE u.parent.id = :id")
		List<User> getStudentsByParent(@Param("id") int id);
		
		
		
		
		

}
