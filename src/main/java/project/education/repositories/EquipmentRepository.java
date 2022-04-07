package project.education.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.education.models.Equipment;

import java.util.List;

@Repository
public interface EquipmentRepository extends CrudRepository<Equipment, Long> {

    List<Equipment> findByName(String name);
}
