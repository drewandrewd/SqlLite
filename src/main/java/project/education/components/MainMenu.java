package project.education.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
public class MainMenu {

    private WellOperations wellCreation;
    private LineReader lineReader;

    public void menu() throws IOException {
        System.out.println("Команды:");
        System.out.println("1. Создание скважины: create <название скважены> <колличесиво оборудования>");
        System.out.println("2. Обновить скважины: update <название скважены> <колличесиво оборудования>");
        System.out.println("3. Удалить скважинц: delete <id скважены>");
        while (true) {
            String line = lineReader.readLine();
            String commands[] = line.split(" ");
            if ("create".equals(commands[0])) {
                wellCreation.createWell(commands[1], Integer.parseInt(commands[2]));
            } else if ("update".equals(commands[0])) {
                wellCreation.updateWell(commands[1], Integer.parseInt(commands[2]));
            } else if ("delete".equals(commands[0])) {
                wellCreation.deleteWell(Integer.parseInt(commands[1]));
            } else {
                System.out.println("Wrong command");
            }
        }
    }

    @Autowired
    public void setWellCreation(WellOperations wellCreation) {
        this.wellCreation = wellCreation;
    }

    @Autowired
    public void setLineReader(LineReader lineReader) {
        this.lineReader = lineReader;
    }

}
