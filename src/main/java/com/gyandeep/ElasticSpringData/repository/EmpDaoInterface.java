package com.gyandeep.ElasticSpringData.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.gyandeep.ElasticSpringData.model.Employee;


public interface EmpDaoInterface extends ElasticsearchRepository<Employee, String> {
	
	Page<Employee> findByName(String name, Pageable pageable);
	Page<Employee> findByEmail(String email, Pageable pageable);
	Page<Employee> findByNameAndEmail(String name, String email, Pageable pageable);
		

}
