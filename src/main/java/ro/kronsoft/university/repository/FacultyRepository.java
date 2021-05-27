package ro.kronsoft.university.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.kronsoft.university.entity.Faculty;

import java.util.List;
@Repository
public interface FacultyRepository extends CrudRepository<Faculty, Integer> {

    public List<Faculty> findByName(String name);
}
