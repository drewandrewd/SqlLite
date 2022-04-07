package project.education.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.education.exceptions.WellNotFoundException;
import project.education.models.Equipment;
import project.education.models.Well;
import project.education.services.EquipmentServiceImpl;
import project.education.services.WellServiceImpl;

@Component
public class WellCreation {

    private EquipmentServiceImpl equipmentService;
    private WellServiceImpl wellService;

    public void createWell(String name, int pieces) throws WellNotFoundException {
        Well well = new Well();
        well.setName(name);
        wellService.create(well);
        for (int i = 0; i < pieces; i++) {
            Equipment equipment = new Equipment();
            equipment.setWell(wellService.findByName(name));
        }
    }

    @Autowired
    public void setEquipmentService(EquipmentServiceImpl equipmentService) {
        this.equipmentService = equipmentService;
    }

    @Autowired
    public void setWellService(WellServiceImpl wellService) {
        this.wellService = wellService;
    }
}
