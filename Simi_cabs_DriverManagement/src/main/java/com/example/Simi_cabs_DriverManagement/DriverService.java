package com.example.Simi_cabs_DriverManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DriverService {
	@Autowired
	DriverRepository repo;
	
	@Transactional(readOnly=true)
	public Driver getDriver(Integer driverId) {
		return repo.getOne(driverId);
		
	}
	@Transactional
	public Driver createDriver(Driver objDriver)
	{
	 return repo.save(objDriver);	
	}
	public String deleteDriver(Integer driverId)
	{
		repo.deleteById(driverId);
		System.out.println("deleted");
		return "successfully deleted id="+driverId;
	
	}
	public String updateDriver(Driver objDriver)
	{
		repo.save(objDriver);
		System.out.println("updated");
		return "successfully updated for id="+objDriver;
		
	}
	
	public List<Driver> getAllDriver() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
}


