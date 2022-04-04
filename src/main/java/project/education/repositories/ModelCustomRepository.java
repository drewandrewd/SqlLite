package project.education.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import project.education.models.Well;

import java.util.List;


public interface ModelCustomRepository {

    List<Well> fetchAll(String field, Sort.Direction direction);
    Page<Well> fetchAllWithPagination(String field, Sort.Direction direction, int pages, int size);
}
