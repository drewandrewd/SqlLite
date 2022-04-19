package project.education.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.education.models.wells.Well;
import project.education.repositories.WellRepository;

@Service
public class WellServiceImpl implements WellService {

    private WellRepository wellRepository;

    @Override
    public void create(Well well) {
        String wellName = well.getName();
        boolean same = true;
        for (String curr : wellRepository.findAllNames()) {
            if (wellName.equals(curr)) {
                same = false;
                break;
            }
        }
        if (same) {
            wellRepository.save(well);
        }
    }

    @Autowired
    public void setWellRepository(WellRepository wellRepository) {
        this.wellRepository = wellRepository;
    }
}
