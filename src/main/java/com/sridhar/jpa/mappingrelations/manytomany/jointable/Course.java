package com.sridhar.jpa.mappingrelations.manytomany.jointable;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
@Entity
@Table(name = "course")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Course {
    @Id
    @GeneratedValue
    private long id;
    @Column(name="course_name")
    private String courseName;
    @Column(name = "duration")
    private Double duration;
    @ManyToMany(mappedBy = "likedCourses")
    private List<Student> likes;
}
