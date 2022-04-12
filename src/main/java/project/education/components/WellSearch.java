package project.education.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.education.models.Well;
import project.education.repositories.EquipmentRepository;
import project.education.repositories.WellRepository;

import java.util.List;

@Component
public class WellSearch {

    private WellRepository wellRepository;
    private EquipmentRepository equipmentRepository;

    public void wellSearch(List<String> wellNames) {
        for (String name : wellNames) {
            Well well = wellRepository.findByName(name);
            int equipmentTotal = equipmentRepository.findNamesByWell(well).size();
            System.out.println(name + ": " + equipmentTotal);
        }
    }

    @Autowired
    public void setWellRepository(WellRepository wellRepository) {
        this.wellRepository = wellRepository;
    }

    @Autowired
    public void setEquipmentRepository(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }
}
