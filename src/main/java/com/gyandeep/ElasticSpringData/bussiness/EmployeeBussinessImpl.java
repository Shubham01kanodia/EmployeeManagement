package com.gyandeep.ElasticSpringData.bussiness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gyandeep.ElasticSpringData.model.Employee;
import com.gyandeep.ElasticSpringData.repository.EmpDaoInterface;

@Service
public class EmployeeBussinessImpl implements EmpBusinessInterface{

	@Autowired
	EmpDaoInterface empDaoInterface;
	

	public Employee addEmployee(Employee emp) {
		
		return empDaoInterface.save(emp);
	}

}
