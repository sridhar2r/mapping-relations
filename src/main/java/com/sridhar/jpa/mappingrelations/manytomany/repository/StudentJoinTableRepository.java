package com.sridhar.jpa.mappingrelations.manytomany.repository;

import com.sridhar.jpa.mappingrelations.manytomany.jointable.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
public interface StudentJoinTableRepository extends JpaRepository<Student, Long> {
    List<Student> findByName(String name);
}
