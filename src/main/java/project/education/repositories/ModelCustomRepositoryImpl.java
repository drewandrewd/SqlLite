package project.education.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import project.education.models.Well;

import java.util.List;

@Repository
public class ModelCustomRepositoryImpl implements ModelCustomRepository{

    private MongoTemplate mongoTemplate;

    @Override
    public List<Well> fetchAll(String field, Sort.Direction direction) {
        Query query = new Query();
        query.with(Sort.by(direction, field));
        return mongoTemplate.find(query, Well.class);
    }

    @Override
    public Page<Well> fetchAllWithPagination(String field, Sort.Direction direction, int pages, int size) {
        Pageable pageable = PageRequest.of(pages, size, Sort.by(direction, field));
        Query query = new Query();
        query.with(pageable);
        return new PageImpl<>( mongoTemplate.find(query, Well.class));
    }

    @Autowired
    public void setMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }
}
