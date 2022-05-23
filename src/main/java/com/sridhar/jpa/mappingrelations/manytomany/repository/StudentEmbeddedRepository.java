package com.sridhar.jpa.mappingrelations.manytomany.repository;

import com.sridhar.jpa.mappingrelations.manytomany.embedded.Student1;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
public interface StudentEmbeddedRepository extends JpaRepository<Student1, Long> {
    List<Student1> findByName(String name);
}
