package project.education.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.education.models.Equipment;
import project.education.repositories.EquipmentRepository;

import java.util.List;

@Service
public class EquipmentServiceImpl implements EquipmentService {

    private EquipmentRepository repository;

    @Override
    public List<EquipmentService> findByName(String name) {
        return null;
    }

    @Override
    public void create(Equipment equipment) {
        repository.save(equipment);
    }

    @Autowired
    public void setRepository(EquipmentRepository repository) {
        this.repository = repository;
    }
}
