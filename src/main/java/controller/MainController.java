package controller;

import dao.PomiarDao;
import dao.jdbc.PomiarDaoJdbcImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

import java.util.HashSet;

public class MainController {

    PomiarDao dao = PomiarDaoJdbcImpl.getInstance();

    @FXML
    TabPane tabPane;
    @FXML
    Tab dodajPomiar;
    @FXML
    Tab rozpoznajOsobe;
    @FXML
    Tab badanieJakosciSystemu;

    @FXML
    public void initialize() {

    }

}
