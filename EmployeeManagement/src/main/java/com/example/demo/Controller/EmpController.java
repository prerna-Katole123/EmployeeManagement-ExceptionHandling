package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Employee;
import com.example.demo.Service.EmpService;

@RestController
public class EmpController {
	@Autowired
	EmpService es;

	@PostMapping("employee")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee e)

	{
		try {
			es.saveEmployeeData(e);
		} catch (RuntimeException r) {
			return new ResponseEntity<String>(r.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<String>("employee saved", HttpStatus.CREATED);

	}

	@PostMapping("addemployees")
	public List<Employee> saveAllEmployee(@RequestBody List<Employee> e) {
		return es.saveListOfEmployee(e);
	}

	@GetMapping("emp/{id}")
	public ResponseEntity<Employee> getEmployeeInfo(@PathVariable int id) {
		try {
			Employee e = es.getEmployeeInfo(id);
			return new ResponseEntity<Employee>(e, HttpStatus.OK);
		} catch (RuntimeException r) {
			return new ResponseEntity(r.getMessage(), HttpStatus.NO_CONTENT);
		}

	}

	@GetMapping("getemployees")
	public List<Employee> getAllEmployees()

	{
		return es.getAllEmployeeInfo();
	}

	@DeleteMapping("deleteemp/{id}")
	public ResponseEntity deleteEmployee(@PathVariable int id) {
		try {
		es.deleteEmployee(id);
		return new ResponseEntity<>("employee deleted", HttpStatus.OK);
		}catch (RuntimeException r) {
			return new ResponseEntity<>(r.getMessage(), HttpStatus.NO_CONTENT);
		}
		
	}

}
