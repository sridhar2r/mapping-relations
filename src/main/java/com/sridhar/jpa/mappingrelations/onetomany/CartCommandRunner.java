package com.sridhar.jpa.mappingrelations.onetomany;

import com.sridhar.jpa.mappingrelations.onetomany.foreignkey.Cart;
import com.sridhar.jpa.mappingrelations.onetomany.foreignkey.Item;
import com.sridhar.jpa.mappingrelations.onetomany.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
@Component
public class CartCommandRunner implements CommandLineRunner {
    @Autowired
    private CartRepository cartRepository;

    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        LocalDate today = LocalDate.now();
        List<Item> items = new ArrayList<Item>() {
            {
                add(Item.builder().name("Sugar").price(50.5).quantity(1d).build());
                add(Item.builder().name("Rice").price(50.5).quantity(4.5d).build());
            }
        };
        List<Item> items1 = new ArrayList<Item>() {
            {
                add(Item.builder().name("Jaggery").price(100d).quantity(1d).build());
                add(Item.builder().name("Jamun").price(45d).quantity(.5d).build());
            }
        };

        Double totalPrice = getTotalPrice(items);
        Cart cart = Cart.builder().purchaserName("Sridhar").purchaseDate(today).totalPrice(totalPrice)
                .items(items).build();
        Double totalPrice1 = getTotalPrice(items1);
        Cart cart1 = Cart.builder().purchaserName("Mani").purchaseDate(today).totalPrice(totalPrice1)
                .items(items1).build();
        cartRepository.save(cart);
        cartRepository.save(cart1);

        System.out.println(cartRepository.findByPurchaserNameAndPurchaseDate("Sridhar", today));
        System.out.println(cartRepository.findByPurchaserNameAndPurchaseDate("Mani", today));
    }

    private Double getTotalPrice(List<Item> items) {
           /*items.stream()
                .mapToDouble(item -> item.getPrice())
                .sum();*/
        return items.stream().map(item -> item.getPrice()).reduce(0d, (subTotal, price) -> subTotal + price);
    }
}
