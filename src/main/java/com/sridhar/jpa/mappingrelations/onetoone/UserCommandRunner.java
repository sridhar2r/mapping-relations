package com.sridhar.jpa.mappingrelations.onetoone;

import com.sridhar.jpa.mappingrelations.onetoone.foreignkey.Address;
import com.sridhar.jpa.mappingrelations.onetoone.foreignkey.User;
import com.sridhar.jpa.mappingrelations.onetoone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
@Component
public class UserCommandRunner implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void run(String... strings) throws Exception {
        Address address = Address.builder().city("Madurai").street("Mullai Malar Street").build();
        User user = User.builder().userName("abc@gmail.com").address(address).build();
        userRepository.save(user);

        User user1 = User.builder().userName("null_address@gmail.com").build();
        userRepository.save(user1);
    }
}
