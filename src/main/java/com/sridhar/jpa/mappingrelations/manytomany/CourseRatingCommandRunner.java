package com.sridhar.jpa.mappingrelations.manytomany;

import com.sridhar.jpa.mappingrelations.manytomany.embedded.Course1;
import com.sridhar.jpa.mappingrelations.manytomany.embedded.CourseRating;
import com.sridhar.jpa.mappingrelations.manytomany.embedded.Student1;
import com.sridhar.jpa.mappingrelations.manytomany.repository.CourseRatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
//@Component
public class CourseRatingCommandRunner implements CommandLineRunner {
    @Autowired
    private CourseRatingRepository ratingRepository;
    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        Course1 coursePhysics = Course1.builder().courseName("Physics").duration(5.5).build();
        Student1 student = Student1.builder().name("Sridhar").section("12A").build();
        CourseRating courseRating1 = CourseRating.builder()
                .student(student)
                .course(coursePhysics)
                .rating(4)
                .build();
        student.setRatings(Arrays.asList(courseRating1));
        coursePhysics.setRatings(Arrays.asList(courseRating1));
        ratingRepository.save(courseRating1);
    }
}
