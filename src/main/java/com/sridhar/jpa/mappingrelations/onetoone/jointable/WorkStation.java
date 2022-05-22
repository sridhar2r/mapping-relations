package com.sridhar.jpa.mappingrelations.onetoone.jointable;

import lombok.*;

import javax.persistence.*;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
/*
if the lookup doesn't happen within @Transactional and having @ToString on referenced object
For fetch type eager, will cause stack overflow

Exception Stack Trace example

java.lang.StackOverflowError: null
	at java.lang.AbstractStringBuilder.append(AbstractStringBuilder.java:671) ~[na:1.8.0_73]
	at java.lang.StringBuilder.append(StringBuilder.java:214) ~[na:1.8.0_73]
	at com.sridhar.jpa.mappingrelations.onetoone.jointable.WorkStation.toString(WorkStation.java:21) ~[classes/:na]
	at java.lang.String.valueOf(String.java:2994) ~[na:1.8.0_73]
	at java.lang.StringBuilder.append(StringBuilder.java:131) ~[na:1.8.0_73]
	at com.sridhar.jpa.mappingrelations.onetoone.jointable.Employee.toString(Employee.java:16) ~[classes/:na]
	at java.lang.String.valueOf(String.java:2994) ~[na:1.8.0_73]

For fetch type lazy, method will get lazy load initialization exception

Exception Stack Trace example

java.lang.IllegalStateException: Failed to execute CommandLineRunner
	at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:774) [spring-boot-2.7.0.jar:2.7.0]
	at org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:755) [spring-boot-2.7.0.jar:2.7.0]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:315) [spring-boot-2.7.0.jar:2.7.0]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1306) [spring-boot-2.7.0.jar:2.7.0]
	at org.springframework.boot.SpringApplication.run(SpringApplication.java:1295) [spring-boot-2.7.0.jar:2.7.0]
	at com.sridhar.jpa.mappingrelations.MappingRelationsApplication.main(MappingRelationsApplication.java:10) [classes/:na]
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:1.8.0_73]
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:1.8.0_73]
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:1.8.0_73]
	at java.lang.reflect.Method.invoke(Method.java:497) ~[na:1.8.0_73]
	at com.intellij.rt.execution.application.AppMain.main(AppMain.java:147) [idea_rt.jar:na]
Caused by: org.hibernate.LazyInitializationException: could not initialize proxy [com.sridhar.jpa.mappingrelations.onetoone.jointable.WorkStation#2] - no Session

*/
@Entity
@Table(name = "workstation")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class WorkStation {
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;
    @Column(name = "workstation_number")
    private long workstationNumber;
    @Column(name = "floor")
    private String floor;
    @OneToOne(mappedBy = "workStation")
    private Employee employee;
}
