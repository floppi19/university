package ro.kronsoft.university.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.kronsoft.university.entity.University;
import ro.kronsoft.university.repository.UniversityRepository;

import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UniversityRestController {
    @Autowired
    private UniversityRepository universityRepository;


    @GetMapping("/university")
    public Response findAllWithParam(@QueryParam("name") String name, @QueryParam("city") String city) {
        List<University> universityList = new ArrayList<>();
        if (name != null && !name.isEmpty() && city != null && !city.isEmpty()) {
            universityList = universityRepository.findByNameAndCity(name, city);
        } else if (name != null && !name.isEmpty()) {
            universityList = universityRepository.findByName(name);
        } else if (city != null && !city.isEmpty()) {
            universityList = universityRepository.findByCity(city);
        } else {
            universityList = (List<University>) universityRepository.findAll();
        }
        return Response.ok(universityList).build();

    }

    @PostMapping("university/add")
    public Response insertIntoDatabase(@RequestBody final University university) {
        universityRepository.save(university);
        return Response.ok(university).build();
    }

    @PutMapping("university/{id}")
    public Response universityUpdate(@RequestBody University university, @PathVariable int id) {
        universityRepository.findById(id)
                .map(newUniversity -> {
                    newUniversity.setName(university.getName());
                    newUniversity.setCity(university.getCity());
                    return universityRepository.save(newUniversity);

                });
        return Response.ok().build();
    }


    @DeleteMapping("university/delete/{id}")
    public Response universityDelete(@PathVariable int id) {
        Optional<University> university = universityRepository.findById(id);
        if (university.isPresent()) {
            return Response.ok().build();
        } else {
            return Response.noContent().build();
        }

    }

}
