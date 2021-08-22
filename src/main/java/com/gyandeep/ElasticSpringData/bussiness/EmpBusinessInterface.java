package com.gyandeep.ElasticSpringData.bussiness;

import java.util.List;

import com.gyandeep.ElasticSpringData.model.Employee;

public interface EmpBusinessInterface {
	Employee addEmployee(Employee emp);
	List<Employee> getAllEmployee(Integer pageNo, Integer pageSize, String sortBy, String name, String email);
	
}
