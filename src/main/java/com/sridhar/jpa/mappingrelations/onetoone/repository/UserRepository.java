package com.sridhar.jpa.mappingrelations.onetoone.repository;

import com.sridhar.jpa.mappingrelations.onetoone.foreignkey.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
