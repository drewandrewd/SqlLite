package project.education.services;

import project.education.exceptions.WellNotFoundException;
import project.education.models.Well;

import java.util.List;

public interface WellService {

    Well findByName(String name) throws WellNotFoundException;
    void create(Well well);
}
