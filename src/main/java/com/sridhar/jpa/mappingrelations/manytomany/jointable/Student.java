package com.sridhar.jpa.mappingrelations.manytomany.jointable;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
@Entity
@Table(name = "student")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Student {
    @Id
    @GeneratedValue
    private long id;
    @Column(name="name")
    private String name;
    @Column(name="section")
    private String section;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course_like",
    joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")},
    inverseJoinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "id")})
    private List<Course> likedCourses;
}
