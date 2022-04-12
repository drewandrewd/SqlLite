package project.education.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Well {
    @Id
    @GeneratedValue
    @javax.persistence.Id
    @Column(name = "id")
    private Integer id;

    @Column(nullable = false)
    private String name;
}
