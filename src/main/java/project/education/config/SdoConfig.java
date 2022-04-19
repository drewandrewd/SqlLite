package project.education.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.education.models.wells.Well;
import ru.ep.sdo.Session;
import ru.ep.sdo.SessionFactory;
import ru.ep.sdo.def.SessionMetaData;
import ru.ep.sdo.filter.LikeFilter;
import ru.ep.sdo.list.XMLListModel;
import ru.ep.sdo.tree.XMLTreeListModel;

import java.util.Properties;

@Configuration
public class SdoConfig {

    @Bean
    public Properties propertiesSdo() {
        Properties properties = new Properties();
        properties.setProperty(SessionMetaData.PROPERTY_DRIVER_CLASS_NAME,
                "org.sqlite.JDBC");
        properties.setProperty(SessionMetaData.PROPERTY_CONNECTION_STRING,
                "jdbc:sqlite:your.db");
        properties.setProperty(SessionMetaData.PROPERTY_USER, "admin");
        properties.setProperty(SessionMetaData.PROPERTY_PASSWORD, "admin");
        return properties;
    }

    public Session sessionSdo() {
        Session session = SessionFactory.getInstance().createSessionFromFile("new.session", propertiesSdo());
        return session;
    }

    public XMLListModel wellModelSdo() {
        XMLListModel listModel = sessionSdo().getListModel("SDO.Well");
        listModel.setWhereClause("NAME LIKE ?");
        listModel.setWhereClauseParam(0, "Тест%");
        listModel.setFilter(new LikeFilter(
                new String[] {Well.PROPERTYNAME_NAME},
                new Object[] {"Тест%"}));
        listModel.setOrderClause("NAME ASC");
        listModel.fetchAllImmediate();
        listModel.setOrderClause(null);
        return listModel;
    }


    public XMLTreeListModel wellTreeModelSdo() {
        XMLTreeListModel treeListModel = sessionSdo().getTreeListModel("SDO.WellTree");

        XMLListModel level = treeListModel.getLevel("SDO.Well");
        level.setFilter(new LikeFilter(
                new String[] {Well.PROPERTYNAME_NAME},
                new Object[] {"Тест%"}));
        level.setOrderClause("NAME ASC");
        return treeListModel;
    }
}
