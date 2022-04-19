package project.education.sdo;

import project.education.models.wells.Well;

public interface WellCrud {

    void create(Well well);
    void update(Integer id);
    void delete(Integer id);
}
