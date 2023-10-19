package com.udemy.repository;

import com.udemy.entity.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepositoryInterface extends CrudRepository<Customer, Long> { }
