package com.example.Simi_cabs_DriverManagement;



import javax.sql.DataSource;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;




@SpringBootApplication
public class SimiCabsDriverManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimiCabsDriverManagementApplication.class, args);
	}
	@Bean
	public DataSource getDataSource()
	{
		EmbeddedDatabaseBuilder edb=new EmbeddedDatabaseBuilder();
		edb.setType(EmbeddedDatabaseType.H2);
		return edb.build();
	}
	}

