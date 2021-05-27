package ro.kronsoft.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ro.kronsoft.university.entity.Mark;

@Repository
public interface MarkRepository extends JpaRepository<Mark,Integer> {
}
