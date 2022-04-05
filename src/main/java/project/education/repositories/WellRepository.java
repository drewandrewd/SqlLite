package project.education.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.education.models.Well;

import java.util.List;

@Repository
public interface WellRepository extends CrudRepository<Well, Long> {

    List<Well> findByName(String name);
}
