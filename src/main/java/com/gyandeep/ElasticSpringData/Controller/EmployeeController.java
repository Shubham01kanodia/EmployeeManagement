package com.gyandeep.ElasticSpringData.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gyandeep.ElasticSpringData.bussiness.EmpBusinessInterface;
import com.gyandeep.ElasticSpringData.model.Employee;

@RestController
public class EmployeeController {
	
	@Autowired
	EmpBusinessInterface empBusinessInterface;	


	@GetMapping("/employee-details/{id}")
	public Employee getEmployeeById(@PathVariable("id")String id)
	{
		System.out.println("Get employee details id :: "+id);
		Optional<Employee>  empOptional = empBusinessInterface.getEmployeelById(id);
		if(empOptional.isPresent())
		{
			return empOptional.get();
		}
		return null;
	}
	
	/*@GetMapping("/employee")
	public Iterable<Employee> getAllEmployee()
	{
		System.out.println("get all Employee ");
		return empBusinessInterface.getAllEmployee();
	}*/
	
	@GetMapping("/employee")
	public List<Employee> getAllEmployee(
            @RequestParam(defaultValue = "1") Integer pageNo, 
            @RequestParam(defaultValue = "2") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "") String name,
            @RequestParam(defaultValue = "") String email)
	{
		System.out.println("get all Employee 2");
		return empBusinessInterface.getAllEmployee(pageNo, pageSize, sortBy, name, email);
	}
	
	
	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee)
	{
		System.out.println("adding Employee "+employee);
		return empBusinessInterface.addEmployee(employee);
	}
	
	@PostMapping("/employee-List")
	public List<Employee> addEmployeeList(@RequestBody List<Employee> employeeList)
	{
		System.out.println("adding Employee "+employeeList);
		return empBusinessInterface.addEmployee(employeeList);
	}
	
	@DeleteMapping("/employee-details/{id}")
	public String deleteEmployee(@PathVariable("id")String id)
	{
		System.out.println("@DeleteMapping Employee "+id);
		empBusinessInterface.deleteEmployee(id);
		return "Employee Deleted "+id;
	}
	
	@PostMapping("/employee-details/{id}")
	public String updateEmployeeDetails(@PathVariable("id")String id, @RequestBody Employee employee)
	{
		System.out.println("@@PostMapping Employee "+id+":: "+employee);
		empBusinessInterface.updateEmployee(id, employee);
		return "Updated Employee "+id;
	}
}
