package com.gyandeep.ElasticSpringData.bussiness;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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


	@Override
	public List<Employee> getAllEmployee(Integer pageNo, Integer pageSize, String sortBy, String name, String email) {
		if(pageNo<=0 || pageSize<=1)
		{
			System.out.println("Page Number or Page Size cannot be less than 1");
			return new ArrayList<Employee>();
		}
		Pageable paging = PageRequest.of(pageNo-1, pageSize, Sort.by(sortBy));
		Page<Employee> pagedResult = null;
		if(name.isEmpty() && email.isEmpty())
		{
			pagedResult = empDaoInterface.findAll(paging);
         
		}
		else if(!name.isEmpty() && !email.isEmpty())
		{
			pagedResult = empDaoInterface.findByNameAndEmail(name, email, paging);
		}
		else if(!name.isEmpty())
		{
			//List<Employee> temp = empDaoInterface.findByName(name);
			pagedResult = empDaoInterface.findByName(name, paging);
		}
		else
		{
			pagedResult = empDaoInterface.findByEmail(email, paging);
		}
		
        if(null != pagedResult && pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Employee>();
        }
	}

}
