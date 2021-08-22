package com.gyandeep.ElasticSpringData.bussiness;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


	public Iterable<Employee> getAllEmployee() {

		return empDaoInterface.findAll();
	}


	public Optional<Employee> getEmployeelById(String id) {
		return empDaoInterface.findById(id);
	}


	public long deleteEmployee(String id) {
		
		Optional<Employee> employeeDetails =  empDaoInterface.findById(id);
		long retValue = 0;
		if(employeeDetails.isPresent())
		{
			retValue = employeeDetails.get().getId();
			empDaoInterface.delete(employeeDetails.get());
		}
		return retValue;
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


	@Override
	public List<Employee> addEmployee(List<Employee> emp) {
		
		return (List<Employee>)empDaoInterface.saveAll(emp);
	}

	public Employee updateEmployee(String id, Employee emp) {
		Optional<Employee>  empDataOptional = empDaoInterface.findById(id);
		if(empDataOptional.isPresent())
		{
			Employee empData = empDataOptional.get();
			empData.setAbout(emp.getAbout());
			empData.setCountry(emp.getCountry());
			empData.setCoverPicture(emp.getCoverPicture());
			empData.setCreatedAt(emp.getCreatedAt());
			empData.setCreditBalance(emp.getCreditBalance());
			empData.setDob(emp.getDob());
			empData.setEnablefollowme(emp.isEnablefollowme());
			empData.setEnabletagging(emp.isEnabletagging());
			empData.setGender(emp.getGender());
			empData.setLat(emp.getLat());
			empData.setLivelat(emp.getLivelat());
			empData.setLiveLocation(emp.getLiveLocation());
			empData.setLng(emp.getLng());
			empData.setLivelng(emp.getLivelng());
			empData.setLocation(emp.getLocation());
			empData.setMyCash(emp.getMyCash());
			empData.setName(emp.getName());
			empData.setPassword(emp.getPassword());
			empData.setProfilePicture(emp.getProfilePicture());
			empData.setSendmenotifications(emp.isSendmenotifications());
			empData.setSendTextmessages(emp.isSendTextmessages());
			empData.setToken(null);
			empData.setUpdatedAt(null);
			empData.setUserStatus(0);
			empData.setUserType(0);
			return empDaoInterface.save(empData);	
		}
		return null;
	}

}
