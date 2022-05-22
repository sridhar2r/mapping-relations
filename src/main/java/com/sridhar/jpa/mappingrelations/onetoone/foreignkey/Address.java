package com.sridhar.jpa.mappingrelations.onetoone.foreignkey;

import lombok.*;

import javax.persistence.*;

/**
 * Created by sridharrajagopal on 5/21/22.
 */
@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {
    @Id
    @GeneratedValue
    @Column(name="id")
    private long id;
    @Column(name="street")
    private String street;
    @Column(name="city")
    private String city;
    @OneToOne(mappedBy = "address")
    private User user;
}
