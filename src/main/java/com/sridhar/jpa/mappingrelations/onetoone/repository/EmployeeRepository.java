package com.sridhar.jpa.mappingrelations.onetoone.repository;

import com.sridhar.jpa.mappingrelations.onetoone.jointable.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    Employee findByEmpName(String name);
}
