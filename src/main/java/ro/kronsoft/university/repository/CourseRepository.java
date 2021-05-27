package ro.kronsoft.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.kronsoft.university.entity.Courses;

@Repository
public interface CourseRepository extends JpaRepository<Courses, Integer> {

}
