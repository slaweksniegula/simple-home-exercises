package exercises.simpleexercises.inheritanceTask.bike.hamulec;

public class HamulecZwykly implements Hamulec {


    public static final Double WSPOLCZYNNIK_HAMOWANIA = 0.8;


    @Override
    public void hamuj() {
        System.out.println("Rower hamuje hamulcem zwykłym");
    }

    @Override
    public Double getWspolczynnikHamowania() {
        return WSPOLCZYNNIK_HAMOWANIA;
    }
}
