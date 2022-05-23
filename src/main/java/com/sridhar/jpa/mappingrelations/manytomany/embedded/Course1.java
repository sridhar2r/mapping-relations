package com.sridhar.jpa.mappingrelations.manytomany.embedded;

import lombok.*;

import javax.persistence.*;
import java.util.List;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
@Entity
@Table(name = "course1")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course1 {
    @Id
    @GeneratedValue
    @Column(name = "course_id")
    private long courseId;
    @Column(name="course_name")
    private String courseName;
    @Column(name = "duration")
    private Double duration;
    @OneToMany(mappedBy = "course")
    List<CourseRating> ratings;
}
