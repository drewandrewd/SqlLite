package project.education.sdo;

import org.springframework.beans.factory.annotation.Autowired;
import project.education.config.SdoConfig;
import project.education.models.wells.Well;

public class WellCrudImpl implements WellCrud{

    private SdoConfig sdoConfig;

    @Override
    public void create(Well well) {
        sdoConfig.wellModelSdo().add(well);
        sdoConfig.sessionSdo().commit();
    }

    @Override
    public void update(Integer id) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Autowired
    public void setSdoConfig(SdoConfig sdoConfig) {
        this.sdoConfig = sdoConfig;
    }
}
