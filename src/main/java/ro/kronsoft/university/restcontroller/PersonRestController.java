package ro.kronsoft.university.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.kronsoft.university.entity.Person;
import ro.kronsoft.university.repository.PersonRepository;

import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonRestController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/person")
    public Response findAll() {
        List<Person> personList = new ArrayList<>();
        personList = (List<Person>) personRepository.findAll();
        return Response.ok(personList).build();
    }
        @PostMapping("/person/add")
        public Response insertIntoDatabase(@RequestBody final Person person) {
            personRepository.save(person);
            return Response.ok(person).build();

    }
    @PutMapping("person/{id}")
    public Response personUpdate(@RequestBody Person person, @PathVariable int id) {

        personRepository.findById(id)
                .map(newPerson -> {
                    newPerson.setFirstName(person.getFirstName());
                    newPerson.setLastName(person.getLastName());
                    newPerson.setCnp(person.getCnp());
                    newPerson.setFaculty(person.getFaculty());
                    newPerson.setYearOfStudy(person.getYearOfStudy());
                    newPerson.setGroupNumber(person.getGroupNumber());
                    newPerson.setProfile(person.getProfile());
                    newPerson.setType(person.getType());

                    return personRepository.save(newPerson);

                });
        return Response.ok().build();
    }
    @DeleteMapping("person/delete/{id}")
    public Response personDelete(@PathVariable int id) {
        personRepository.deleteById(id);
        return Response.ok().build();
    }

}
