package com.sridhar.jpa.mappingrelations.onetomany.foreignkey;

import lombok.*;

import javax.persistence.*;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
@Entity
@Table(name = "item")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "quantity")
    private Double quantity;
    @ManyToOne
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    private Cart cart;
}
