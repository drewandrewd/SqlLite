package project.education.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import project.education.SqliteApplication;
import project.education.exceptions.WellNotFoundException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.Arrays;

@Component
public class MainMenu {

    private WellCreation wellCreation;
    private LineReader lineReader;
    private WellSearch wellSearch;
    private XmlWriter xmlWriter;

    public void menu() throws IOException, WellNotFoundException, ParserConfigurationException, TransformerException {
        while (true) {
            String line = lineReader.readLine();
            if ("create well".equals(line)) {
                String command = lineReader.readLine();
                String[] commands = command.split(" ");
                wellCreation.createWell(commands[0], Integer.parseInt(commands[1]));
            } else if ("total well".equals(line)) {
                String command = lineReader.readLine();
                String[] commands = command.split(" ");
                wellSearch.wellSearch(Arrays.asList(commands));
            } else if ("xml".equals(line)) {
                String command = lineReader.readLine();
                xmlWriter.writeXml(command);
            } else {
                System.out.println("Wrong command");
            }
        }
    }

    @Autowired
    public void setWellCreation(WellCreation wellCreation) {
        this.wellCreation = wellCreation;
    }

    @Autowired
    public void setLineReader(LineReader lineReader) {
        this.lineReader = lineReader;
    }

    @Autowired
    public void setWellSearch(WellSearch wellSearch) {
        this.wellSearch = wellSearch;
    }

    @Autowired
    public void setXmlWriter(XmlWriter xmlWriter) {
        this.xmlWriter = xmlWriter;
    }
}
