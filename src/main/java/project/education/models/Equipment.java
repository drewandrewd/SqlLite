package project.education.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Data
public class Equipment {
    @Id
    @GeneratedValue
    @javax.persistence.Id
    @Column(name = "id")
    private Integer id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "well_id")
    private Well well;
}
