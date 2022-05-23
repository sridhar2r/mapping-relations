package com.sridhar.jpa.mappingrelations.manytomany;

import com.sridhar.jpa.mappingrelations.manytomany.jointable.Course;
import com.sridhar.jpa.mappingrelations.manytomany.jointable.Student;
import com.sridhar.jpa.mappingrelations.manytomany.repository.StudentJoinTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
//@Component
public class StudentJoinTableCommandRunner implements CommandLineRunner {
    @Autowired
    private StudentJoinTableRepository repository;
    @Override
    @Transactional
    public void run(String... strings) throws Exception {
        Course courseJava = Course.builder().courseName("Java").duration(4d).build();
        Course coursePhysics = Course.builder().courseName("Physics").duration(5.5).build();
        List<Course> courses = new ArrayList<Course>() {
            {
                add(courseJava);
                add(coursePhysics);
            }
        };
        Student student = Student.builder().name("Sridhar").section("12A").likedCourses(courses).build();
       // courseJava.setLikes(Arrays.asList(student));
       // coursePhysics.setLikes(Arrays.asList(student));
        repository.save(student);
        List<Student> students = repository.findByName("Sridhar");
        students.forEach(System.out::println);
       /* students.forEach(std -> {
            std.getLikedCourses().forEach(System.out::println);
        });*/
    }
}
