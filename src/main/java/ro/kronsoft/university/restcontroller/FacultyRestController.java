package ro.kronsoft.university.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.kronsoft.university.entity.Faculty;
import ro.kronsoft.university.repository.FacultyRepository;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FacultyRestController {

    @Autowired
    private FacultyRepository facultyRepository;

    @GetMapping("/faculty")
    public Response findAllWithParam(@QueryParam("name") String name) {
        List<Faculty> facultyList = new ArrayList<>();
        if (name != null && !name.isEmpty()) {
            facultyList = facultyRepository.findByName(name);
        } else {
            facultyList = (List<Faculty>) facultyRepository.findAll();
        }
        return Response.ok(facultyList).build();
    }

    @PostMapping("faculty/add")
    public Response insertIntoDatabase(@RequestBody final Faculty faculty) {
        facultyRepository.save(faculty);
        return Response.ok(faculty).build();
    }

    @PutMapping("faculty/{id}")
    public Response facultyUpdate(@RequestBody Faculty faculty, @PathVariable int id) {

        facultyRepository.findById(id)
                .map(newFaculty -> {
                    newFaculty.setName(faculty.getName());
                    return facultyRepository.save(newFaculty);

                });
        return Response.ok().build();
    }

    @DeleteMapping("faculty/delete/{id}")
    public Response facultyDelete(@PathVariable int id) {
        facultyRepository.deleteById(id);
        return Response.ok().build();
    }

}
