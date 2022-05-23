package com.sridhar.jpa.mappingrelations.manytomany.embedded;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
@Entity
@Table(name = "student1")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Student1 {
    @Id
    @GeneratedValue
    @Column(name = "student_id")
    private long studentId;
    @Column(name = "name")
    private String name;
    @Column(name="section")
    private String section;
    @OneToMany(mappedBy = "student")
    List<CourseRating> ratings;
}
