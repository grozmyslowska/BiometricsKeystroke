package controller;

import dao.PomiarDao;
import dao.jdbc.PomiarDaoJdbcImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import model.Pomiar;

import java.util.HashSet;

public class DodajPomiarController {

    PomiarDao dao = PomiarDaoJdbcImpl.getInstance();

    @FXML
    public ComboBox<String> imie;
    @FXML
    public TextArea poleDoPisania;
    @FXML
    public Button resetButton;
    @FXML
    public Button okButton;

    int lastCode = -1;
    long timeLast = -1;
    String keyText = "";

    final long[] czas = new long[26];
    final int[] ilosc = new int[26];
    final int[] srednia = new int[26];

    HashSet<String> imiona;

    @FXML
    void initialize() {
        imiona = dao.findNames();
        imie.getItems().setAll(imiona);
    }

    @FXML
    public void wybranieImienia(){
        poleDoPisania.setDisable(false);
        resetButton.setDisable(false);
        okButton.setDisable(false);
    }

    @FXML
    public void onKeyPressed(KeyEvent e){
        keyText = e.getCode().toString();
        lastCode = keyText.charAt(0);
        timeLast = System.currentTimeMillis();
    }

    @FXML
    public void onKeyReleased(KeyEvent e){
        if(lastCode!=-1) {
            long measuredTime = System.currentTimeMillis() - timeLast;
            if (lastCode > 64 && lastCode < 91) {
                int litera = lastCode - 65;
                czas[litera] += measuredTime;
                ilosc[litera]++;
                srednia[litera] = (int) (czas[litera] / ilosc[litera]);
                System.out.println(String.format("Code:%d,time%d",lastCode,measuredTime));
            }
        }
    }

    @FXML
    public void okButtonPressed(){

        dao.save(new Pomiar(imie.getValue(), srednia[0], srednia[1], srednia[2], srednia[3], srednia[4], srednia[5], srednia[6], srednia[7], srednia[8], srednia[9], srednia[10], srednia[11], srednia[12], srednia[13], srednia[14], srednia[15], srednia[16], srednia[17], srednia[18], srednia[19], srednia[20], srednia[21], srednia[22], srednia[23], srednia[24], srednia[25]));

        imiona = dao.findNames();
        imie.getItems().setAll(imiona);

        imie.setValue(null);
        poleDoPisania.clear();
        poleDoPisania.setDisable(true);
        resetButton.setDisable(true);
        okButton.setDisable(true);

        lastCode = -1;
        timeLast = -1;
        keyText = "";

        for (int i=0; i<26; i++){
            czas[i] = 0;
            ilosc[i] = 0;
            srednia[i] = 0;
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Dodano próbkę",ButtonType.OK);
        alert.showAndWait();
    }

    @FXML
    public void cancelButtonPressed(){
        imie.setValue(null);
        poleDoPisania.clear();
        poleDoPisania.setDisable(true);
        resetButton.setDisable(true);
        okButton.setDisable(true);

        lastCode = -1;
        timeLast = -1;
        keyText = "";

        for (int i=0; i<26; i++){
            czas[i] = 0;
            ilosc[i] = 0;
            srednia[i] = 0;
        }
    }

}
