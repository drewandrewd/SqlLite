package project.education.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.education.models.Well;

import java.util.List;

@Repository
public interface WellRepository extends CrudRepository<Well, Long> {

    @Query("select u from Well u where u.name = ?1")
    Well findByName(String name);

    @Query("select name from Well")
    List<String> findAllNames();

    @Query("select u from Well u")
    List<Well> findAllWells();
}
