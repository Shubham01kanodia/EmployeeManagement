package com.gyandeep.ElasticSpringData.bussiness;

import java.util.List;
import java.util.Optional;

import com.gyandeep.ElasticSpringData.model.Employee;

public interface EmpBusinessInterface {
	Employee addEmployee(Employee emp);
	Iterable<Employee> getAllEmployee();
	Optional<Employee> getEmployeelById(String id);
	long deleteEmployee(String id);
	List<Employee> getAllEmployee(Integer pageNo, Integer pageSize, String sortBy, String name, String email);
	List<Employee> addEmployee(List<Employee> emp);
	Employee updateEmployee(String id, Employee emp);
	
}
