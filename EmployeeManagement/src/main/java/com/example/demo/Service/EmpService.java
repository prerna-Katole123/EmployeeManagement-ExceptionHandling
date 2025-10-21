package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Employee;
import com.example.demo.Repository.EmpRepo;

@Service
public class EmpService {
	@Autowired
	EmpRepo er;

	public void saveEmployeeData(Employee e) {
		if (e.getName().length() > 10) {
			throw new RuntimeException("invalid name");
		}
		er.save(e);
	}

	public Employee getEmployeeInfo(int id) {
		if (id > 100) {

			throw new RuntimeException("not available");
		}
		return er.findById(id).get();

	}

	public List<Employee> getAllEmployeeInfo() {
		return er.findAll();
	}

	public List<Employee> saveListOfEmployee(List<Employee> e) {
		return er.saveAll(e);
	}

	public void deleteEmployee(int id) {
		if(id>100)
		{
			throw new RuntimeException("you cant delete");
		}
		er.deleteById(id);
	}
}
