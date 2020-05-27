package com.spring.myschool.restful.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.spring.myschool.restful.model.LogSession;

public interface LogSessionRepository extends CrudRepository<LogSession, Integer>, JpaRepository<LogSession, Integer> {

	//@Query("SELECT s FROM LogSession s WHERE s.user.id = :userconnectedId AND s.dateDeconnexion is null order by s.id desc limit 1")
	@Query(value="SELECT s.* from log_session s WHERE s.user_id = :userconnectedId AND s.date_deconnexion is null ORDER BY s.id DESC LIMIT 1", nativeQuery = true)
	LogSession getSessionByUserLogin(@Param("userconnectedId") int userconnectedId);
	
	
}

