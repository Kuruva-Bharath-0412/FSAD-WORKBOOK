package exp7_crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exp7_crud.entity.Course;
import exp7_crud.repository.CourseRepository;

@Service
public class CourseService {

    @Autowired
    private CourseRepository repository;

    public Course addCourse(Course course) {
        return repository.save(course);
    }

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public Optional<Course> getCourseById(int id) {
        return repository.findById(id);
    }

    public Course updateCourse(Course course) {
        return repository.save(course);
    }

    public void deleteCourse(int id) {
        repository.deleteById(id);
    }

    public List<Course> searchByTitle(String title) {
        return repository.findByTitleContaining(title);
    }
}