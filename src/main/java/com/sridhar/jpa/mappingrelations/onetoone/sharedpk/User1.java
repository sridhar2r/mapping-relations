package com.sridhar.jpa.mappingrelations.onetoone.sharedpk;

import lombok.*;

import javax.persistence.*;

/**
 * Created by sridharrajagopal on 5/21/22.
 */
@Entity
@Table(name = "users1")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "user_name")
    private String userName;
    //Works fine even without PrimaryKeyJoinColumn.
    // Just an indicator that primary key of users1 is used as foreign key value of associated address1
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address1 address;
}
