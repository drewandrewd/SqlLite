package project.education.services;

import project.education.models.Equipment;

import java.util.List;

public interface EquipmentService {

    List<EquipmentService> findByName(String name);
    void create(Equipment equipment);
}
