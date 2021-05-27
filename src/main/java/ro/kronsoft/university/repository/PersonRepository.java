package ro.kronsoft.university.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.kronsoft.university.entity.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Integer> {
}
