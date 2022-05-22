package com.sridhar.jpa.mappingrelations.onetoone.foreignkey;

import lombok.*;

import javax.persistence.*;

/**
 * Created by sridharrajagopal on 5/21/22.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "user_name")
    private String userName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName="id")
    private Address address;

}
