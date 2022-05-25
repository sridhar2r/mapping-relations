package com.sridhar.jpa.mappingrelations.mergecascade;

import com.sridhar.jpa.mappingrelations.mergecascade.model.Customer;
import com.sridhar.jpa.mappingrelations.mergecascade.model.PhoneDetail;
import com.sridhar.jpa.mappingrelations.mergecascade.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sridharrajagopal on 5/24/22.
 */
@Component
public class CustomerRunner implements CommandLineRunner {
    @Autowired
    private CustomerRepository repo;
    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        PhoneDetail phoneDetail = PhoneDetail.builder().phoneName("6x").model("Iphone").price(50000d).build();
        Customer customer = Customer.builder().name("Sridhar").phoneDetails(new ArrayList<>(Arrays.asList(phoneDetail))).build();
        phoneDetail.setCustomer(customer);
        Customer respCust = repo.save(customer);

        //Without below code which updates existing data, Cascade merge will not save phone detail data when first call was made, as changes are now
        // propogated to phone detail only in case of update
        Customer custLookup = repo.findById(respCust.getId()).orElse(null);
        custLookup.setName("Sridhar R");
        custLookup.getPhoneDetails().get(0).setPhoneName("7plus");
        repo.save(custLookup);
        System.out.println(respCust);
    }
}
