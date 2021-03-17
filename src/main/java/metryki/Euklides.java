package metryki;

import model.Pomiar;

public class Euklides {

    public static Integer cal(Pomiar p1, Pomiar p2){
        int wynik = 0;

        wynik += Math.abs(p1.getTimeA() - p2.getTimeA());
        wynik += Math.abs(p1.getTimeB() - p2.getTimeB());
        wynik += Math.abs(p1.getTimeC() - p2.getTimeC());
        wynik += Math.abs(p1.getTimeD() - p2.getTimeD());
        wynik += Math.abs(p1.getTimeE() - p2.getTimeE());
        wynik += Math.abs(p1.getTimeF() - p2.getTimeF());
        wynik += Math.abs(p1.getTimeG() - p2.getTimeG());
        wynik += Math.abs(p1.getTimeH() - p2.getTimeH());
        wynik += Math.abs(p1.getTimeI() - p2.getTimeI());
        wynik += Math.abs(p1.getTimeJ() - p2.getTimeJ());
        wynik += Math.abs(p1.getTimeK() - p2.getTimeK());
        wynik += Math.abs(p1.getTimeL() - p2.getTimeL());
        wynik += Math.abs(p1.getTimeM() - p2.getTimeM());
        wynik += Math.abs(p1.getTimeN() - p2.getTimeN());
        wynik += Math.abs(p1.getTimeO() - p2.getTimeO());
        wynik += Math.abs(p1.getTimeP() - p2.getTimeP());
        wynik += Math.abs(p1.getTimeQ() - p2.getTimeQ());
        wynik += Math.abs(p1.getTimeR() - p2.getTimeR());
        wynik += Math.abs(p1.getTimeS() - p2.getTimeS());
        wynik += Math.abs(p1.getTimeT() - p2.getTimeT());
        wynik += Math.abs(p1.getTimeU() - p2.getTimeU());
        wynik += Math.abs(p1.getTimeV() - p2.getTimeV());
        wynik += Math.abs(p1.getTimeW() - p2.getTimeW());
        wynik += Math.abs(p1.getTimeX() - p2.getTimeX());
        wynik += Math.abs(p1.getTimeY() - p2.getTimeY());
        wynik += Math.abs(p1.getTimeZ() - p2.getTimeZ());

        return wynik;
    }
}
