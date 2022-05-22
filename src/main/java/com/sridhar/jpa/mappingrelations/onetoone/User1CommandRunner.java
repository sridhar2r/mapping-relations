package com.sridhar.jpa.mappingrelations.onetoone;

import com.sridhar.jpa.mappingrelations.onetoone.foreignkey.Address;
import com.sridhar.jpa.mappingrelations.onetoone.foreignkey.User;
import com.sridhar.jpa.mappingrelations.onetoone.repository.User1Repository;
import com.sridhar.jpa.mappingrelations.onetoone.repository.UserRepository;
import com.sridhar.jpa.mappingrelations.onetoone.sharedpk.Address1;
import com.sridhar.jpa.mappingrelations.onetoone.sharedpk.User1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
@Component
public class User1CommandRunner implements CommandLineRunner {
    @Autowired
    private User1Repository userRepository;
    @Override
    public void run(String... strings) throws Exception {
        Address1 address = Address1.builder().city("Chennai").street("Kooduvancheri").build();
        User1 user = User1.builder().userName("gef@gmail.com").address(address).build();
        address.setUser(user);
        userRepository.save(user);
    }
}
