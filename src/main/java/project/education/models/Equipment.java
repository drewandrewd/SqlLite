package project.education.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.*;

@Entity
@Data
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @javax.persistence.Id
    @Column(name = "id", nullable = false)
    private Long id;

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
////    private String id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "well_id")
    private Well well;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
