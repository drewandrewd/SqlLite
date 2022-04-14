package project.education.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Component;
import project.education.SqliteApplication;
import project.education.exceptions.WellNotFoundException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class MainMenu {

    private WellCreation wellCreation;
    private LineReader lineReader;
    private WellSearch wellSearch;
    private XmlWriter xmlWriter;

    public void menu() throws IOException, WellNotFoundException, ParserConfigurationException, TransformerException {
        System.out.println("Команды:");
        System.out.println("1. Создание скважины с оборудованием: create <название скважены> <колличество оборудования>");
        System.out.println("2. Выводит на колличество оборудования у введенной скважины: total <название скважены> <название скважены> ...");
        System.out.println("3. Запуск создания xml файла: xml");
        while (true) {
            String line = lineReader.readLine();
            String commands[] = line.split(" ");
            if ("create".equals(commands[0])) {
                wellCreation.createWell(commands[1], Integer.parseInt(commands[2]));
            } else if ("total".equals(commands[0])) {
                ArrayList<String> listWell = new ArrayList<>();
                Collections.addAll(listWell, commands);
                listWell.remove(0);
                wellSearch.wellSearch(listWell);
            } else if ("xml".equals(commands[0])) {
                xmlWriter.writeXml(commands[1]);
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
