package project.education;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import project.education.components.MainMenu;
import project.education.exceptions.WellNotFoundException;

import javax.annotation.PostConstruct;
import java.io.IOException;

@SpringBootApplication
public class SqliteApplication {

    private MainMenu mainMenu;

    public static void main(String[] args) {
        SpringApplication.run(SqliteApplication.class, args);
    }

    @PostConstruct
    public void doRun() throws WellNotFoundException, IOException {
        mainMenu.menu();
    }

    @Autowired
    public void setMainMenu(MainMenu mainMenu) {
        this.mainMenu = mainMenu;
    }
}
