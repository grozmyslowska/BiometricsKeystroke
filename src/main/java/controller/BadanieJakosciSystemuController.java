package controller;

import dao.PomiarDao;
import dao.jdbc.PomiarDaoJdbcImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.text.Text;
import javafx.util.Pair;
import metryki.Czebyszew;
import metryki.Euklides;
import metryki.Manhattan;
import model.Pomiar;

import java.util.*;

public class BadanieJakosciSystemuController {

    public LineChart<Number,Number> wykresE;
    public NumberAxis xAxisE;
    public NumberAxis yAxisE;
    public LineChart<Number,Number> wykresM;
    public NumberAxis xAxisM;
    public NumberAxis yAxisM;
    public LineChart<Number,Number> wykresC;
    public NumberAxis xAxisC;
    public NumberAxis yAxisC;

    PomiarDao dao = PomiarDaoJdbcImpl.getInstance();

    @FXML
    public Button resetButton;

    @FXML
    void initialize() {

        //Setting label to the axis
        xAxisE.setLabel("Parametr k");
        xAxisM.setLabel("Parametr k");
        xAxisC.setLabel("Parametr k");

        //Setting labelto the axis
        yAxisE.setLabel("Poprawność klasyfikacji %");
        yAxisM.setLabel("Poprawność klasyfikacji %");
        yAxisC.setLabel("Poprawność klasyfikacji %");

        this.oblicz();
    }

    @FXML
    public void cancelButtonPressed(){
        this.oblicz();
    }

    public void oblicz(){

        int K = 10;

        int[] effectEukl = new int[K+1];
        int[] effectManh = new int[K+1];
        int[] effectCzeb = new int[K+1];

        List<Pomiar> pomiary = dao.findAll();

        yAxisE.setUpperBound(100);
        xAxisE.setUpperBound(K);
        yAxisM.setUpperBound(100);
        xAxisM.setUpperBound(K);
        yAxisC.setUpperBound(100);
        xAxisC.setUpperBound(K);

        for(Pomiar p : pomiary){

            List<Pair<Integer,Pomiar>> listaEuklides = new LinkedList<>();
            List<Pair<Integer,Pomiar>> listaManhattan = new LinkedList<>();
            List<Pair<Integer,Pomiar>> listaCzebyszew = new LinkedList<>();

            for(Pomiar q : pomiary) {
                if (q != p) {
                    listaEuklides.add(new Pair<>(Euklides.cal(p, q), q));
                    listaManhattan.add(new Pair<>(Manhattan.cal(p, q), q));
                    listaCzebyszew.add(new Pair<>(Czebyszew.cal(p, q), q));
                }
            }

            List<Pair<Integer,Pomiar>> newlistaEuklides = sortujListeWgOcen(listaEuklides);
            List<Pair<Integer,Pomiar>> newlistaManhattan = sortujListeWgOcen(listaManhattan);
            List<Pair<Integer,Pomiar>> newlistaCzebyszew = sortujListeWgOcen(listaCzebyszew);

            for(int k=1;k<=K;k++){
                if(p.getName().equals(znajdzImieWgK(newlistaEuklides,k))) effectEukl[k]++;
                if(p.getName().equals(znajdzImieWgK(newlistaManhattan,k))) effectManh[k]++;
                if(p.getName().equals(znajdzImieWgK(newlistaCzebyszew,k))) effectCzeb[k]++;
            }
        }

        XYChart.Series<Number, Number> seriesEuklides = new XYChart.Series<Number, Number>();
        seriesEuklides.setName("Euklides");
        XYChart.Series<Number, Number> seriesManhattan = new XYChart.Series<Number, Number>();
        seriesManhattan.setName("Manhattan");
        XYChart.Series<Number, Number> seriesCzebyszew = new XYChart.Series<Number, Number>();
        seriesCzebyszew.setName("Czebyszew");

        int val = pomiary.size()-1;

        for(int k=1;k<=K;k++){
            seriesEuklides.getData().add(new XYChart.Data<Number, Number>(k, effectEukl[k]*100/val));
            seriesManhattan.getData().add(new XYChart.Data<Number, Number>(k, effectManh[k]*100/val));
            seriesCzebyszew.getData().add(new XYChart.Data<Number, Number>(k, effectCzeb[k]*100/val));
        }

        ObservableList<XYChart.Series<Number, Number>> dataE = FXCollections.<XYChart.Series<Number, Number>>observableArrayList();
        dataE.add(seriesEuklides);
        wykresE.setData(dataE);

        ObservableList<XYChart.Series<Number, Number>> dataM = FXCollections.<XYChart.Series<Number, Number>>observableArrayList();
        dataM.add(seriesManhattan);
        wykresM.setData(dataM);

        ObservableList<XYChart.Series<Number, Number>> dataC = FXCollections.<XYChart.Series<Number, Number>>observableArrayList();
        dataC.add(seriesCzebyszew);
        wykresC.setData(dataC);

    }

    public List<Pair<Integer,Pomiar>> sortujListeWgOcen(List<Pair<Integer,Pomiar>> lista){
        lista.sort(new Comparator<Pair<Integer, Pomiar>>() {
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
        return lista;
    }

    public String znajdzImieWgK(List<Pair<Integer,Pomiar>> lista, int k){

        List<String> imieZnalezione = new LinkedList<>();

        for(int i=0;i<k;i++){
            imieZnalezione.add(lista.get(i).getValue().getName());
        }

        HashMap<String,Integer> imieIloscWystapien = new HashMap<>();

        for(String s : imieZnalezione){
            imieIloscWystapien.put(s,0);
        }

        String wynikImie = "";
        int maxFreq = 0;

        for(String s : imieZnalezione){
            int i = imieIloscWystapien.get(s)+1;
            imieIloscWystapien.put(s,i);
            if(i>maxFreq){
                wynikImie = s;
                maxFreq = i;
            }
        }

        return wynikImie;
    }

}
