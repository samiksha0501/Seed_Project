package com.example.Simi_cabs_DriverManagement;

import static org.junit.Assert.assertTrue;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@DataJpaTest
public class RepoTest {
	RepoTest repository;
	
	@Test
	public void findByUsernameShouldReturnUser() {
		Driver entity=new Driver();
		entity.setName("ajay");
		entity.setId(100);
		
		entity.setAddress("JPNagar");
		entity.setContactno(98876);
		
		this.repository.save(entity);
		Optional<Driver> user=this.repository.findById(100);
		
		if (user.isPresent()) {
			System.out.println(user.get().getName());
		}
	}

}
