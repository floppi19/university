package ro.kronsoft.university.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.kronsoft.university.entity.Courses;
import ro.kronsoft.university.repository.CourseRepository;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CourseRestController {

    @Autowired
    private CourseRepository courseRepository;

    @GetMapping("/course")
    public Response findAll() {
        List<Courses> coursesList = new ArrayList<>();
        coursesList = (List<Courses>) courseRepository.findAll();
        return Response.ok(coursesList).build();
    }

    @PostMapping("/course/add")
    public Response insertIntoDatabase(@RequestBody final Courses courses) {
        courseRepository.save(courses);
        return Response.ok(courses).build();

    }

    @PutMapping("course/{id}")
    public Response courseUpdate(@RequestBody Courses courses, @PathVariable int id) {

        courseRepository.findById(id)
                .map(newCourses -> {
                    newCourses.setName(newCourses.getName());
                    newCourses.setPerson(newCourses.getPerson());
                    newCourses.setYearOfStudy(newCourses.getYearOfStudy());
                    newCourses.setCreditNumber(newCourses.getCreditNumber());
                    return courseRepository.save(newCourses);

                });
        return Response.ok().build();
    }

    @DeleteMapping("course/delete/{id}")
    public Response courseDelete(@PathVariable int id) {
        courseRepository.deleteById(id);
        return Response.ok().build();
    }
}
