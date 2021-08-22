package com.gyandeep.ElasticSpringData.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.gyandeep.ElasticSpringData.model.Employee;


public interface EmpDaoInterface extends ElasticsearchRepository<Employee, String> {
	
	Optional<Employee> findById(long id);
	Iterable<Employee> findAll();
	Page<Employee> findAll(Pageable pageable);
	Page<Employee> findByName(String name, Pageable pageable);
	Page<Employee> findByEmail(String email, Pageable pageable);
	Page<Employee> findByNameAndEmail(String name, String email, Pageable pageable);
	//List<Employee> findByName(String name);

	//void delete(Employee entity);
	//Employee save(Employee entity);
		

}
