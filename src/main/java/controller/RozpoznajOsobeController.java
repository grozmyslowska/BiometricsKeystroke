package controller;

import dao.PomiarDao;
import dao.jdbc.PomiarDaoJdbcImpl;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;
import javafx.util.Pair;
import metryki.Czebyszew;
import metryki.Euklides;
import metryki.Manhattan;
import model.Pomiar;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class RozpoznajOsobeController {

    PomiarDao dao = PomiarDaoJdbcImpl.getInstance();

    @FXML
    public ComboBox<String> metryka;
    @FXML
    public Slider parametrK;
    @FXML
    public TextArea poleDoPisania;
    @FXML
    public Button resetButton;
    @FXML
    public Button okButton;
    @FXML
    public Text przedK;
    @FXML
    public Text poK;

    int lastCode = -1;
    long timeLast = -1;
    String keyText = "";

    final long[] czas = new long[26];
    final int[] ilosc = new int[26];
    final int[] srednia = new int[26];

    @FXML
    void initialize() {
        metryka.getItems().setAll("Euklides","Manhattan","Czebyszew");

        StringBuilder stringBuilder = new StringBuilder();
        List<Pomiar> pomiary = dao.findAll();

        for(Pomiar p : pomiary){
            stringBuilder.append(p.getName()+"   A:"+p.getTimeA()+"  B:"+p.getTimeB()+"  C:"+p.getTimeC()+"  D:"+p.getTimeD()+"  E:"+p.getTimeE()+"  F:"+p.getTimeF()+"  G:"+p.getTimeG()+"  H:"+p.getTimeH()+"  I:"+p.getTimeI()+"  J:"+p.getTimeJ()+"  K:"+p.getTimeK()+"  L:"+p.getTimeL()+"  M:"+p.getTimeM()+"  N:"+p.getTimeN()+"  O:"+p.getTimeO()+"  P:"+p.getTimeP()+"  Q:"+p.getTimeQ()+"  R:"+p.getTimeR()+"  S:"+p.getTimeS()+"  T:"+p.getTimeT()+"  U:"+p.getTimeU()+"  V:"+p.getTimeV()+"  W:"+p.getTimeW()+"  X:"+p.getTimeX()+"  Y:"+p.getTimeY()+"  Z:"+p.getTimeZ()+"\n");
        }

        przedK.setText(stringBuilder.toString());
        poK.setText("");

    }

    @FXML
    public void wybranieMetryki(){
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

        Pomiar pomiarTest = new Pomiar("pomiar", srednia[0], srednia[1], srednia[2], srednia[3], srednia[4], srednia[5], srednia[6], srednia[7], srednia[8], srednia[9], srednia[10], srednia[11], srednia[12], srednia[13], srednia[14], srednia[15], srednia[16], srednia[17], srednia[18], srednia[19], srednia[20], srednia[21], srednia[22], srednia[23], srednia[24], srednia[25]);

        List<Pomiar> pomiary = dao.findAll();

        List<Pair<Integer,Pomiar>> listaPoliczona = new LinkedList<>();

        for(Pomiar p : pomiary){
            switch (metryka.getValue()) {
                case "Euklides":
                    listaPoliczona.add(new Pair<>(Euklides.cal(p, pomiarTest), p));
                    break;
                case "Manhattan":
                    listaPoliczona.add(new Pair<>(Manhattan.cal(p, pomiarTest), p));
                    break;
                case "Czebyszew":
                    listaPoliczona.add(new Pair<>(Czebyszew.cal(p, pomiarTest), p));
                    break;
            }
        }

        listaPoliczona.sort(new Comparator<Pair<Integer, Pomiar>>() {
            @Override
            public int compare(Pair<Integer, Pomiar> o1, Pair<Integer, Pomiar> o2) {
                if (o1.getKey() < o2.getKey()) {
                    return -1;
                } else if (o1.getKey().equals(o2.getKey())) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });

        StringBuilder stringBuilderPrzedK = new StringBuilder();
        StringBuilder stringBuilderPoK = new StringBuilder();
        List<String> imieZnalezione = new LinkedList<>();

        for(int i=0;i<parametrK.getValue();i++){
            Pomiar p = listaPoliczona.get(i).getValue();
            stringBuilderPrzedK.append(p.getName()+"   A:"+p.getTimeA()+"  B:"+p.getTimeB()+"  C:"+p.getTimeC()+"  D:"+p.getTimeD()+"  E:"+p.getTimeE()+"  F:"+p.getTimeF()+"  G:"+p.getTimeG()+"  H:"+p.getTimeH()+"  I:"+p.getTimeI()+"  J:"+p.getTimeJ()+"  K:"+p.getTimeK()+"  L:"+p.getTimeL()+"  M:"+p.getTimeM()+"  N:"+p.getTimeN()+"  O:"+p.getTimeO()+"  P:"+p.getTimeP()+"  Q:"+p.getTimeQ()+"  R:"+p.getTimeR()+"  S:"+p.getTimeS()+"  T:"+p.getTimeT()+"  U:"+p.getTimeU()+"  V:"+p.getTimeV()+"  W:"+p.getTimeW()+"  X:"+p.getTimeX()+"  Y:"+p.getTimeY()+"  Z:"+p.getTimeZ()+"  Wynik:"+listaPoliczona.get(i).getKey()+"\n");
            imieZnalezione.add(p.getName());
        }
        for(int i = (int) parametrK.getValue(); i<listaPoliczona.size(); i++){
            Pomiar p = listaPoliczona.get(i).getValue();
            stringBuilderPoK.append(p.getName()+"   A:"+p.getTimeA()+"  B:"+p.getTimeB()+"  C:"+p.getTimeC()+"  D:"+p.getTimeD()+"  E:"+p.getTimeE()+"  F:"+p.getTimeF()+"  G:"+p.getTimeG()+"  H:"+p.getTimeH()+"  I:"+p.getTimeI()+"  J:"+p.getTimeJ()+"  K:"+p.getTimeK()+"  L:"+p.getTimeL()+"  M:"+p.getTimeM()+"  N:"+p.getTimeN()+"  O:"+p.getTimeO()+"  P:"+p.getTimeP()+"  Q:"+p.getTimeQ()+"  R:"+p.getTimeR()+"  S:"+p.getTimeS()+"  T:"+p.getTimeT()+"  U:"+p.getTimeU()+"  V:"+p.getTimeV()+"  W:"+p.getTimeW()+"  X:"+p.getTimeX()+"  Y:"+p.getTimeY()+"  Z:"+p.getTimeZ()+"  Wynik:"+listaPoliczona.get(i).getKey()+"\n");
        }

        przedK.setText(stringBuilderPrzedK.toString());
        poK.setText(stringBuilderPoK.toString());

        HashMap<String,Integer> imiePosortowane = new HashMap<>();
        String wynikImie = "";
        int maxFreq = 0;
        for(String s : imieZnalezione){
            imiePosortowane.put(s,0);
        }
        for(String s : imieZnalezione){
            int i = imiePosortowane.get(s)+1;
            imiePosortowane.put(s,i);
            if(i>maxFreq){
                wynikImie = s;
                maxFreq = i;
            }
        }

        Alert alert = new Alert(Alert.AlertType.INFORMATION,"Przewidywany użytkownik: " + wynikImie ,ButtonType.OK);
        alert.showAndWait();

        metryka.setValue(null);
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

    @FXML
    public void cancelButtonPressed(){

        StringBuilder stringBuilder = new StringBuilder();
        List<Pomiar> pomiary = dao.findAll();

        for(Pomiar p : pomiary){
            stringBuilder.append(p.getName()+"   A:"+p.getTimeA()+"  B:"+p.getTimeB()+"  C:"+p.getTimeC()+"  D:"+p.getTimeD()+"  E:"+p.getTimeE()+"  F:"+p.getTimeF()+"  G:"+p.getTimeG()+"  H:"+p.getTimeH()+"  I:"+p.getTimeI()+"  J:"+p.getTimeJ()+"  K:"+p.getTimeK()+"  L:"+p.getTimeL()+"  M:"+p.getTimeM()+"  N:"+p.getTimeN()+"  O:"+p.getTimeO()+"  P:"+p.getTimeP()+"  Q:"+p.getTimeQ()+"  R:"+p.getTimeR()+"  S:"+p.getTimeS()+"  T:"+p.getTimeT()+"  U:"+p.getTimeU()+"  V:"+p.getTimeV()+"  W:"+p.getTimeW()+"  X:"+p.getTimeX()+"  Y:"+p.getTimeY()+"  Z:"+p.getTimeZ()+"\n");
        }

        przedK.setText(stringBuilder.toString());
        poK.setText("");

        metryka.setValue(null);
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
