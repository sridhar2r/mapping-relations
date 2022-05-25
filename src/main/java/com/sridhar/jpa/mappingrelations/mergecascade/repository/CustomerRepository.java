package com.sridhar.jpa.mappingrelations.mergecascade.repository;

import com.sridhar.jpa.mappingrelations.mergecascade.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sridharrajagopal on 5/24/22.
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
