package com.edubridge.serviceIMPL;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edubridge.model.Employee;
import com.edubridge.repository.EmployeeRepo;
import com.edubridge.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Override
	public Employee addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		
		Employee emp=employeeRepo.save(employee);
		return emp;
	}

	@Override
	public String removeEmployee(int id) {
		// TODO Auto-generated method stub
		
		employeeRepo.deleteById(id);
		return "Delete data Successfully";
	}

	@Override
	public Optional<Employee> findEmpById(int id) {
		// TODO Auto-generated method stub
		
		Optional<Employee> emp=employeeRepo.findById(id);
		
		if(emp.isPresent()) {
		return emp;
		}else {
			return null;
		}
	}

	@Override
	public List<Employee> getAllEmployee() {
		// TODO Auto-generated method stub
		
		List<Employee> empList=employeeRepo.findAll();
		
		return empList;
	}

	@Override
	public String updateEmployee(int id) {
		// TODO Auto-generated method stub
		
		Optional<Employee> emp=employeeRepo.findById(id);
		
		if(emp.isPresent()) {
			Employee emps=new Employee();
			
			employeeRepo.save(emps);
			return "";
		}else {
			return "Employee not found";
		}
		
	}

}
