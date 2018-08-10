package com.example.Simi_cabs_DriverManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class DriverController {
	@Autowired
	DriverService service;
	
	@GetMapping(consumes="application/json",produces="application/json")
	public void createDriver(@RequestBody Driver obj) {
		System.out.println("obj="+obj.getName());

	}

	@GetMapping
	public Driver getDriverById(@PathVariable("id") Integer id) {
 System.out.println("id=" +id);
 return service.getDriver(id);
	}
	@PutMapping
	public String updateDriver(@RequestBody Driver obj)
	{
		System.out.println("obj="+obj.getName());
		return service.updateDriver(obj);
	
		
	}
	@DeleteMapping("/{id")
	public String deleteStudentById(@PathVariable("id") Integer id) {
		return service.deleteDriver(id);
			
	}
	
	@GetMapping(produces="appliation/json")
	public List<Driver> getAllDriver()
	{
		return service.getAllDriver();
	}
	
	
	
	
	
}

