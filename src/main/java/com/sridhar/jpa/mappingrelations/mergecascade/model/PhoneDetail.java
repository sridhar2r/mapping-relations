package com.sridhar.jpa.mappingrelations.mergecascade.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by sridharrajagopal on 5/24/22.
 */
@Entity
@Table(name = "phone_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PhoneDetail {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "phone_name")
    private String phoneName;
    @Column(name = "model")
    private String model;
    @Column(name = "price")
    private Double price;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
}
