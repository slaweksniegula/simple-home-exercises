package exercises.simpleexercises.inheritanceTask.bike;

import exercises.simpleexercises.inheritanceTask.bike.hamulec.Hamulec;
import exercises.simpleexercises.inheritanceTask.bike.przerzutka.Przerzutka;
import exercises.simpleexercises.inheritanceTask.bike.rama.Rama;

public class Rower {

private Hamulec hamulec;
private Przerzutka przerzutka;
private Rama rama;

    public Rower(Hamulec hamulec, Przerzutka przerzutka, Rama rama) {
        this.hamulec = hamulec;
        this.przerzutka = przerzutka;
        this.rama = rama;
    }

    public double getMaksymalnaPredkosc(){
        return ((double) przerzutka.getBieg()*8)-(double)(rama.getCiezar())*1.21;
    }

    public double obliczDrogeHamowania(){
        return (przerzutka.getBieg()*2.2-rama.getCiezar()*0.1)*hamulec.getWspolczynnikHamowania();
    }

    public void zwiekszBiegRoweru(){//zad 2 żeby nie odwoływać się podwójnie do metody
        przerzutka.zwiekszBieg();
    }
    public void zmniejszBiegRoweru(){
        przerzutka.zmniejszBieg();
    }

    public Hamulec getHamulec() {
        return hamulec;
    }


}
