package metryki;

import model.Pomiar;

public class Manhattan {

    public static Integer cal(Pomiar p1, Pomiar p2){
        int wynik = 0;
        int val;

        val = Math.abs(p1.getTimeA() - p2.getTimeA());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeB() - p2.getTimeB());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeC() - p2.getTimeC());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeD() - p2.getTimeD());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeE() - p2.getTimeE());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeF() - p2.getTimeF());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeG() - p2.getTimeG());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeH() - p2.getTimeH());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeI() - p2.getTimeI());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeJ() - p2.getTimeJ());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeK() - p2.getTimeK());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeL() - p2.getTimeL());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeM() - p2.getTimeM());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeN() - p2.getTimeN());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeO() - p2.getTimeO());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeP() - p2.getTimeP());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeQ() - p2.getTimeQ());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeR() - p2.getTimeR());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeS() - p2.getTimeS());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeT() - p2.getTimeT());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeU() - p2.getTimeU());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeV() - p2.getTimeV());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeW() - p2.getTimeW());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeX() - p2.getTimeX());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeY() - p2.getTimeY());
        if(val > wynik) wynik = val;
        val = Math.abs(p1.getTimeZ() - p2.getTimeZ());
        if(val > wynik) wynik = val;

        return wynik;
    }
}
