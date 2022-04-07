package project.education.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Well {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @javax.persistence.Id
    @Column(name = "well_id", nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @OneToMany
    private List<Equipment> equipments;
}
