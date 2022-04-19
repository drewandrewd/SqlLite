package project.education.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import project.education.models.equipments.Equipment;
import project.education.models.wells.Well;
import project.education.repositories.EquipmentRepository;
import project.education.repositories.WellRepository;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Component
public class XmlWriter {

    private WellRepository wellRepository;
    private EquipmentRepository equipmentRepository;

    public void writeXml(String name) throws ParserConfigurationException, TransformerException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();
        Element rootElement = document.createElement("dbinfo");
        document.appendChild(rootElement);
        List<Well> wellList = wellRepository.findAllWells();
        List<Equipment> equipmentList = equipmentRepository.findAll();
        for (Well well : wellList) {
            List<Equipment> currEquipment = new ArrayList<>();
            for (Equipment equipment : equipmentList) {
                if (equipment.getWell().equals(well)) {
                    currEquipment.add(equipment);
                }
            }
           rootElement.appendChild(getWell(document, well.getName(), well.getId(), equipmentList));
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult file = new StreamResult(new File(name + ".xml"));
        transformer.transform(source, file);
    }

    public static Node getWell(Document document, String name, Integer id, List<Equipment> list) {
        Element well = document.createElement("well");
        well.setAttribute("name", name);
        well.setAttribute("id", id + "");
        for (Equipment equipment : list) {
            well.appendChild(getEquipmentElements(document, equipment.getId(), equipment.getName()));
        }
        return well;
    }

    public static Node getEquipmentElements(Document doc, Integer id, String name) {
        Element node = doc.createElement("equipment");
        node.setAttribute("name", name);
        node.setAttribute("id", id + "");
        return node;
    }

    @Autowired
    public void setWellRepository(WellRepository wellRepository) {
        this.wellRepository = wellRepository;
    }

    @Autowired
    public void setEquipmentRepository(EquipmentRepository equipmentRepository) {
        this.equipmentRepository = equipmentRepository;
    }
}
