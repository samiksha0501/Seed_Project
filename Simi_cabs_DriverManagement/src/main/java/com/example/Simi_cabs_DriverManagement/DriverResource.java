package com.example.Simi_cabs_DriverManagement;


import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class DriverResource {
	@Autowired
	private DriverRepository driverRepository;
	@GetMapping("/Driver")
	public List<Driver> retrieveAllDriver()
	{
		return driverRepository.findAll();
	}
	@GetMapping("/Driver/{id}")
	public Driver retrieveDriver(@PathVariable int id)
	{
		Optional<Driver> driver=driverRepository.findById(id);
		if(driver.isPresent())
		{
			return driver.get();
		}
		return null;
	}
	@DeleteMapping("/driver/{id}")
	public void deleteDriver(@PathVariable int id)
	{
		driverRepository.deleteById(id);
	}
	
	@PostMapping("/Driver")
	public ResponseEntity<Object> createDriver(@RequestBody Driver driver)
	{
	Driver savedDriver=driverRepository.save(driver);
	URI location=ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedDriver.getId()).toUri();
	return ResponseEntity.created(location).build();
	}
	@PutMapping("/Driver/{id}")
	public ResponseEntity<Object> updateDriver(@RequestBody Driver driver,@PathVariable int id)
	{
		Optional<Driver> driverOptional=driverRepository.findById(id);
		if(!driverOptional.isPresent())
		{
			return ResponseEntity.notFound().build();
			
		}
		return ResponseEntity.noContent().build();
	}
	
}
