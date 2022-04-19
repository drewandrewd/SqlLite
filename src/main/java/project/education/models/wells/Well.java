package project.education.models.wells;

import ru.ep.sdo.Entity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import ru.ep.sdo.annotations.Xml;

import javax.persistence.*;

@Data
@Xml(name = "Well")
public class Well extends Entity {

    public static final String PROPERTYNAME_ID = "id";
    public static final String PROPERTYNAME_NAME = "name";

    @Id
    @GeneratedValue
    @javax.persistence.Id
    @Column(name = "id")
    @Xml(name = "id")
    private Integer id;

    @Column(nullable = false)
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
}
