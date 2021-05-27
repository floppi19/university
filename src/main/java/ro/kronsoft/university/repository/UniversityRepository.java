package ro.kronsoft.university.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ro.kronsoft.university.entity.University;

import java.util.List;


@Repository
public interface UniversityRepository extends CrudRepository<University, Integer> {

    public List<University> findByName(String name);
    public List<University> findByCity(String city);
    public List<University> findByNameAndCity(String name, String city);

}
