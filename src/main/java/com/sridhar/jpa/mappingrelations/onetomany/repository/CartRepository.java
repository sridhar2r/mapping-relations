package com.sridhar.jpa.mappingrelations.onetomany.repository;

import com.sridhar.jpa.mappingrelations.onetomany.foreignkey.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
public interface CartRepository extends JpaRepository<Cart, Long> {
    Cart findByPurchaserNameAndPurchaseDate(String name, LocalDate date);
}
