package com.sridhar.jpa.mappingrelations.onetoone.sharedpk;

import lombok.*;

import javax.persistence.*;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
@Entity
@Table(name="address1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address1 {
    @Id
    @Column(name = "user_id")
    private long id;
    @Column(name="street")
    private String street;
    @Column(name="city")
    private String city;
    //Works fine even without MapsId.
    // Just an indicator that primary key values will be copied from User entity
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User1 user;
}
