package com.github.dantebarba.aportestruchos.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.dantebarba.aportestruchos.domain.EventLog;

@Repository
public interface LoggingRepository extends JpaRepository<EventLog, Long> {
		
}
