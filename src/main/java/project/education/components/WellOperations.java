package project.education.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.education.models.wells.Well;
import project.education.sdo.WellCrudImpl;

@Component
public class WellOperations {

    private WellCrudImpl wellCrud;

    public void createWell(String name, int id)  {
        Well well = new Well();
        well.setName(name);
        well.setId(id);
        wellCrud.create(well);
    }

    public void updateWell(String name, int id)  {
        Well well = new Well();
        well.setName(name);
        well.setId(id);
        wellCrud.update(well);
    }

    public void deleteWell(int id)  {
        wellCrud.delete(id);
    }

    @Autowired
    public void setWellCrud(WellCrudImpl wellCrud) {
        this.wellCrud = wellCrud;
    }
}
