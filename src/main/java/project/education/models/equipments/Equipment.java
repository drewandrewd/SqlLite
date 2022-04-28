package project.education.models.equipments;

import ru.ep.sdo.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import project.education.models.wells.Well;
import ru.ep.sdo.annotations.Xml;

import javax.persistence.*;
import java.beans.PropertyChangeSupport;

@Xml(name = "Equipment")
@Data
public class Equipment extends Entity {

    public static final String PROPERTYNAME_ID = "id";
    public static final String PROPERTYNAME_NAME = "name";
    public static final String PROPERTYNAME_WELL = "well";

    @Xml(name = "id")
    private Integer id;

    @Xml(name = "name")
    private String name;

    @Xml(name = "well_id")
    private Well well;

    public void setId(Integer id) {
        Integer oldValue = this.id;
        this.id = id;
        firePropertyChange(PROPERTYNAME_ID, oldValue, id);
    }

    public void setName(String name) {
        String oldValue = this.name;
        this.name = name;
        firePropertyChange(PROPERTYNAME_NAME, oldValue, name);
    }

    public void setWell(Well well) {
        Well oldValue = this.well;
        this.well = well;
        firePropertyChange(PROPERTYNAME_WELL, oldValue, well);
    }
}
