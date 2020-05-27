package com.spring.myschool.restful.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.spring.myschool.restful.model.Compte;

@Repository
public interface CompteRepository extends CrudRepository<Compte, Integer>, JpaRepository<Compte, Integer> {
	
	@Query("SELECT c FROM Compte c WHERE c.login = :login AND c.password = :password AND c.activate = 'yes'")
	Compte authentification(@Param("login") String login, @Param("password") String password);
	
	@Query("SELECT c FROM Compte c WHERE c.login = :login")
	Compte getCompteByLogin(@Param("login") String login);
	
	@Query("SELECT c FROM Compte c WHERE c.id = :id")
	Compte getCompteById(@Param("id") int id);
	
}
