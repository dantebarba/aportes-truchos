package com.github.dantebarba.aportestruchos.repositories;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.github.dantebarba.aportestruchos.domain.Aporte;

@Repository
public interface AportesRepository extends PagingAndSortingRepository<Aporte, Long> {

	List<Aporte> findByDni(String dni);

}
