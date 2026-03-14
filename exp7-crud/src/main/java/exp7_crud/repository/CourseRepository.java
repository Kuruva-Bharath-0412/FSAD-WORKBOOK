package exp7_crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import exp7_crud.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

    List<Course> findByTitleContaining(String title);

}