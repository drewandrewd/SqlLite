package project.education.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import project.education.exceptions.WellNotFoundException;

import java.io.IOException;

@Component
public class MainMenu {

    private WellCreation wellCreation;
    private LineReader lineReader;

    public void menu() throws IOException, WellNotFoundException {
        while (true) {
            String line = lineReader.readLine();
            if ("create well".equals(line)) {
                String command = lineReader.readLine();
                String[] commands = command.split(" ");
                wellCreation.createWell(commands[0], Integer.parseInt(commands[1]));
            } else if ("total well".equals(line)) {

            } else if ("xml".equals(line)) {

            } else if ("quit".equals(line)) {
                System.exit(0);
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
}
