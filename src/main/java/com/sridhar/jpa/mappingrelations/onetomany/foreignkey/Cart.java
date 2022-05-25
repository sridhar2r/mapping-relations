package com.sridhar.jpa.mappingrelations.onetomany.foreignkey;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
@Entity
@Table(name = "cart")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Cart {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "purchaser_name")
    private String purchaserName;
    @Column(name = "purchase_date")
    private LocalDate purchaseDate;
    @Column(name = "totalPrice")
    private Double totalPrice;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Item> items;
}
