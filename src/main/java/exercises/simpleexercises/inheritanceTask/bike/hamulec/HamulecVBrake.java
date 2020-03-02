package exercises.simpleexercises.inheritanceTask.bike.hamulec;

public class HamulecVBrake implements Hamulec {

    private static final Double WSPOLCZYNNIK_HAMOWANIA = 0.3;
    @Override
    public void hamuj() {
        System.out.println("Hamuję hamulcem VBrake");
    }

    @Override
    public Double getWspolczynnikHamowania() {
        return WSPOLCZYNNIK_HAMOWANIA;
    }
}
