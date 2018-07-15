package com.github.dantebarba.aportestruchos.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.github.dantebarba.aportestruchos.domain.EventLog;

@Repository
public interface LoggingRepository extends PagingAndSortingRepository<EventLog, Long> {
	
}
