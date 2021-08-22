package com.gyandeep.ElasticSpringData.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gyandeep.ElasticSpringData.bussiness.EmpBusinessInterface;
import com.gyandeep.ElasticSpringData.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	EmpBusinessInterface empBusinessInterface;	

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		System.out.println("adding Employee "+employee);
		return empBusinessInterface.addEmployee(employee);
	}

}
