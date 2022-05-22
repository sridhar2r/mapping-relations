package com.sridhar.jpa.mappingrelations.onetoone.jointable;

import lombok.*;

import javax.persistence.*;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
@Entity
@Table(name = "employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class Employee {
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;
    @Column(name = "emp_name")
    private String empName;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "emp_workstation",
    joinColumns = {@JoinColumn(name = "employee_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "workstation_id", referencedColumnName = "id")})
    private WorkStation workStation;
}
