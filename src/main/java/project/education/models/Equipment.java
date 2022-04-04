package project.education.models;

import org.springframework.data.annotation.Id;

public class Equipment {

    @Id
    private String id;

    private String name;
    private String wellId;
}
