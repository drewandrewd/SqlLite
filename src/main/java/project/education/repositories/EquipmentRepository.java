package project.education.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.education.models.Equipment;
import project.education.models.Well;

import java.util.List;

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment, Long> {

    @Query("select name from Equipment where well_id = ?1")
    List<String> findNamesByWell(Well well);

    @Query("select u from Equipment u where u.name = ?1")
    Equipment findByName(String name);

    @Query("select u from Equipment u")
    List<Equipment> findAll();
}
