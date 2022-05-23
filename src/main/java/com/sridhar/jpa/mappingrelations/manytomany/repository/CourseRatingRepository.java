package com.sridhar.jpa.mappingrelations.manytomany.repository;

import com.sridhar.jpa.mappingrelations.manytomany.embedded.CourseRating;
import com.sridhar.jpa.mappingrelations.manytomany.embedded.CourseRatingKey;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by sridharrajagopal on 5/22/22.
 */
public interface CourseRatingRepository extends JpaRepository<CourseRating, CourseRatingKey> {
}
