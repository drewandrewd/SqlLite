package project.education.sdo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.education.config.SdoConfig;
import project.education.models.wells.Well;

@Service
public class WellCrudImpl implements WellCrud{

    private SdoConfig sdoConfig;

    @Override
    public void create(Well well) {
        sdoConfig.wellModelSdo().add(well);
        sdoConfig.sessionSdo().commit();
    }

    @Override
    public void update(Well well) {
       Well wellOld = (Well) sdoConfig.wellModelSdo().get(well.getId());
       wellOld.setName(well.getName());
       sdoConfig.sessionSdo().commit();
    }

    @Override
    public void delete(Integer id) {
        sdoConfig.wellModelSdo().remove(id);
        sdoConfig.sessionSdo().commit();
    }

    @Autowired
    public void setSdoConfig(SdoConfig sdoConfig) {
        this.sdoConfig = sdoConfig;
    }
}
