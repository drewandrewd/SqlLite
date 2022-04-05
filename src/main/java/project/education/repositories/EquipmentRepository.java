package project.education.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;

@Repository
public interface EquipmentRepository extends CrudRepository<Book, Long> {

}
