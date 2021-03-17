package metryki;

import model.Pomiar;

public class Czebyszew {

    public static Integer cal(Pomiar p1, Pomiar p2){
        int wynik = 0;

        wynik += Math.pow(p1.getTimeA() - p2.getTimeA(), 2);
        wynik += Math.pow(p1.getTimeB() - p2.getTimeB(), 2);
        wynik += Math.pow(p1.getTimeC() - p2.getTimeC(), 2);
        wynik += Math.pow(p1.getTimeD() - p2.getTimeD(), 2);
        wynik += Math.pow(p1.getTimeE() - p2.getTimeE(), 2);
        wynik += Math.pow(p1.getTimeF() - p2.getTimeF(), 2);
        wynik += Math.pow(p1.getTimeG() - p2.getTimeG(), 2);
        wynik += Math.pow(p1.getTimeH() - p2.getTimeH(), 2);
        wynik += Math.pow(p1.getTimeI() - p2.getTimeI(), 2);
        wynik += Math.pow(p1.getTimeJ() - p2.getTimeJ(), 2);
        wynik += Math.pow(p1.getTimeK() - p2.getTimeK(), 2);
        wynik += Math.pow(p1.getTimeL() - p2.getTimeL(), 2);
        wynik += Math.pow(p1.getTimeM() - p2.getTimeM(), 2);
        wynik += Math.pow(p1.getTimeN() - p2.getTimeN(), 2);
        wynik += Math.pow(p1.getTimeO() - p2.getTimeO(), 2);
        wynik += Math.pow(p1.getTimeP() - p2.getTimeP(), 2);
        wynik += Math.pow(p1.getTimeQ() - p2.getTimeQ(), 2);
        wynik += Math.pow(p1.getTimeR() - p2.getTimeR(), 2);
        wynik += Math.pow(p1.getTimeS() - p2.getTimeS(), 2);
        wynik += Math.pow(p1.getTimeT() - p2.getTimeT(), 2);
        wynik += Math.pow(p1.getTimeU() - p2.getTimeU(), 2);
        wynik += Math.pow(p1.getTimeV() - p2.getTimeV(), 2);
        wynik += Math.pow(p1.getTimeW() - p2.getTimeW(), 2);
        wynik += Math.pow(p1.getTimeX() - p2.getTimeX(), 2);
        wynik += Math.pow(p1.getTimeY() - p2.getTimeY(), 2);
        wynik += Math.pow(p1.getTimeZ() - p2.getTimeZ(), 2);

        wynik = (int) Math.sqrt(wynik);

        return wynik;
    }
}
