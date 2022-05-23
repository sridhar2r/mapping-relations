package com.sridhar.jpa.mappingrelations.manytomany.embedded;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
@ToString
public class CourseRatingKey implements Serializable {
   /* @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;*/
    @GeneratedValue
    @Column(name="student_id")
    private long studentId;
    @GeneratedValue
    @Column(name="course_id")
    private long courseId;
}
