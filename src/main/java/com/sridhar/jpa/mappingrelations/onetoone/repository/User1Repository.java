package com.sridhar.jpa.mappingrelations.onetoone.repository;

import com.sridhar.jpa.mappingrelations.onetoone.sharedpk.User1;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
public interface User1Repository extends JpaRepository<User1, Long> {
}
