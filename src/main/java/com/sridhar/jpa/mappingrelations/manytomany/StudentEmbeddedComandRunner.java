package com.sridhar.jpa.mappingrelations.manytomany;

import com.sridhar.jpa.mappingrelations.manytomany.embedded.Course1;
import com.sridhar.jpa.mappingrelations.manytomany.embedded.CourseRating;
import com.sridhar.jpa.mappingrelations.manytomany.embedded.Student1;
import com.sridhar.jpa.mappingrelations.manytomany.jointable.Student;
import com.sridhar.jpa.mappingrelations.manytomany.repository.StudentEmbeddedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
@Component
public class StudentEmbeddedComandRunner implements CommandLineRunner {
    @Autowired
    private StudentEmbeddedRepository studentRepository;
    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        Course1 courseJava = Course1.builder().courseName("Java").duration(4d).build();
        //Course1 coursePhysics = Course1.builder().courseName("Physics").duration(5.5).build();
        Student1 student = Student1.builder().name("Sridhar").section("12A").build();
        CourseRating courseRating = CourseRating.builder()
                .student(student)
                .course(courseJava)
                .rating(1)
                .build();
       /* CourseRating courseRating1 = CourseRating.builder()
                .student(student)
                .course(coursePhysics)
                .rating(4)
                .build();*/
        student.setRatings(Arrays.asList(courseRating));
        courseJava.setRatings(Arrays.asList(courseRating));
        studentRepository.save(student);
        List<Student1> students = studentRepository.findByName("Sridhar");
        students.forEach(System.out::println);
        students.forEach(std -> {
                    System.out.println(std);
                    std.getRatings()
                            .forEach(cr -> {
                                System.out.println(cr.getCourseRatingKey()+" ---- "+cr.getCourse()+" ---- "+cr.getRating());
                            });
                });
    }
}
