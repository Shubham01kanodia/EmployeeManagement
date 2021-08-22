package com.gyandeep.ElasticSpringData.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.gyandeep.ElasticSpringData.model.Employee;


public interface EmpDaoInterface extends ElasticsearchRepository<Employee, String> {
	

		

}
