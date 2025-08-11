package com.example.customer_service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.customer_service.model.Customer;

@Repository
public interface CustomerRepository  extends JpaRepository<Customer, Long>{
	
	
	Customer findByEmail(String email);
	
	Customer findByName(String nameStr);
	
	Customer findByNameAndEmail(String nameStr, String emailStr);

	List<Customer> findByNameStartingWith(String prefix);
	
	long countByNameStartingWith(String prefix);
	
	@Query("Select c FROM Customer c WHERE c.email LIKE %:domain") 
	List<Customer> findCustomersByEmailDomain(String domain);
	
	//Native SQL - pure SQL query
	@Query(value="select * from customer where age = (select min(age) from customer)",nativeQuery = true)
	Customer findCustomerWithMinAge();
	

}
