package project.education.services;

import org.bson.Document;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import project.education.exceptions.ModelNotFoundException;
import project.education.models.Well;

import java.util.List;

public interface ModelService {

    List<Well> findByName(String name) throws ModelNotFoundException;

    ModelResponse create(ModelRequest modelRequest) throws Throwable;

    ModelResponse update(ModelRequest modelRequest) throws Throwable;

    ModelResponse delete(String id) throws Throwable;

    List<ModelResponse> fetchAll(String field, Sort.Direction direction) throws ModelNotFoundException;

    Page<ModelResponse> fetchAllWithPagination(String field, Sort.Direction direction, int pages, int size);

    ModelResponse fetchById(String id) throws ModelNotFoundException;

    Document createDoc(String id) throws ModelNotFoundException;

    ModelResponse create(Document document) throws Throwable;
}
