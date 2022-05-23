package com.sridhar.jpa.mappingrelations.manytomany.embedded;

import lombok.*;

import javax.persistence.*;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
@Entity
@Table(name = "course_rating1")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseRating {
    @EmbeddedId
    private CourseRatingKey courseRatingKey;
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("student_id")
    @JoinColumn(name = "student_id")
    private Student1 student;
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("course_id")
    @JoinColumn(name = "course_id")
    private Course1 course;
    @Column(name = "rating")
    private int rating;
}
