package project.education.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.education.models.equipments.Equipment;
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
    public Equipment create(Equipment equipment) {
        return repository.save(equipment);
    }

    @Autowired
    public void setRepository(EquipmentRepository repository) {
        this.repository = repository;
    }
}
