package project.education.models.wells;

import ru.ep.sdo.Entity;
import lombok.Data;
import ru.ep.sdo.annotations.Xml;

@Data
@Xml(name = "Well")
public class Well extends Entity {

    public static final String PROPERTYNAME_ID = "id";
    public static final String PROPERTYNAME_NAME = "name";

    @Xml(name = "id")
    private Integer id;

    @Xml(name = "name")
    private String name;

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

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
