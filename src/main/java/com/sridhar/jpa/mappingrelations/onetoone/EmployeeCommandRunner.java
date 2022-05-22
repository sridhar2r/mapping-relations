package com.sridhar.jpa.mappingrelations.onetoone;

import com.sridhar.jpa.mappingrelations.onetoone.jointable.Employee;
import com.sridhar.jpa.mappingrelations.onetoone.jointable.WorkStation;
import com.sridhar.jpa.mappingrelations.onetoone.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
@Component
public class EmployeeCommandRunner implements CommandLineRunner {
    @Autowired
    private EmployeeRepository employeeRepository;
    //Transactional is needed because workStation can be lazily loaded only within a transaction
    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        WorkStation workStation = WorkStation.builder().floor("ground").workstationNumber(123).build();
        Employee employee = Employee.builder().empName("Rajagopal").workStation(workStation).build();
        employeeRepository.save(employee);
        System.out.println(employeeRepository.findByEmpName("Rajagopal"));
        Employee employeeObj = employeeRepository.findByEmpName("Rajagopal");
        System.out.println(employeeObj.getId() + " --- "+employeeObj.getEmpName()+" --- ");
        WorkStation workStationObj = employeeObj.getWorkStation();
        System.out.println(workStationObj.getId()+" --- "+workStationObj.getWorkstationNumber()+" --- "+workStationObj.getFloor());
    }
}
