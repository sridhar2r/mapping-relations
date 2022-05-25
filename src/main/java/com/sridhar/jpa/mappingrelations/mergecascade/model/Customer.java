package com.sridhar.jpa.mappingrelations.mergecascade.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sridharrajagopal on 5/24/22.
 */
@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Customer {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;
    @Column(name = "name")
    private String name;
    @OneToMany(cascade = CascadeType.MERGE, mappedBy="customer")
    private List<PhoneDetail> phoneDetails;
}
