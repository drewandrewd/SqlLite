package project.education.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.education.exceptions.WellNotFoundException;
import project.education.models.Equipment;
import project.education.models.Well;
import project.education.repositories.WellRepository;
import project.education.services.EquipmentServiceImpl;
import project.education.services.WellServiceImpl;

import java.util.Random;

@Component
public class WellCreation {

    private EquipmentServiceImpl equipmentService;
    private WellServiceImpl wellService;
    private WellRepository wellRepository;

    public void createWell(String name, int pieces) throws WellNotFoundException {
        Well well = new Well();
        well.setName(name);
        wellService.create(well);
        for (int i = 0; i < pieces; i++) {
            Equipment equipment = new Equipment();
            equipment.setName(getRandom());
            equipment.setWell(wellRepository.findByName(name));
            equipmentService.create(equipment);
        }
    }

    public static String getRandom() {
            String val = "";
            Random random = new Random();
            for (int i = 0; i < 6; i++) {
                String charOrNum = random.nextInt (2)% 2 == 0? "Char": "num";
                if ("char" .equalsIgnoreCase (charOrNum)) {
                    int choice = random.nextInt (2)% 2 == 0? 65: 97;
                    val += (char) (choice + random.nextInt(26));
                }
                else if ("num" .equalsIgnoreCase (charOrNum)) {
                    val += String.valueOf(random.nextInt(10));
                }
            }
            return val;
    }

    @Autowired
    public void setEquipmentService(EquipmentServiceImpl equipmentService) {
        this.equipmentService = equipmentService;
    }

    @Autowired
    public void setWellService(WellServiceImpl wellService) {
        this.wellService = wellService;
    }

    @Autowired
    public void setWellRepository(WellRepository wellRepository) {
        this.wellRepository = wellRepository;
    }
}
