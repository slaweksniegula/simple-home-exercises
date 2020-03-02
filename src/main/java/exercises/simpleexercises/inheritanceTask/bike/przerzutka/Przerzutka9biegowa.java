package exercises.simpleexercises.inheritanceTask.bike.przerzutka;

public class Przerzutka9biegowa implements Przerzutka {

    public static final int ILOSC_BIEGOW = 9;
    private  int obecnyBieg;

    public Przerzutka9biegowa(int obecnyBieg) {
        this.obecnyBieg = obecnyBieg;
    }

    @Override
    public void zwiekszBieg() {
        if (obecnyBieg < ILOSC_BIEGOW) {
            obecnyBieg++;
            System.out.println("Zwiększono na "  + getBieg());
        } else {
            System.out.println("nie można już zwiększyc biegu");
        }
    }

    @Override
    public void zmniejszBieg() {
        if (obecnyBieg > 1) {
            obecnyBieg--;
            System.out.println("Zmniejszono na " + getBieg());
        }
        else if (obecnyBieg <= 1){
            System.out.println("Nie można już zmniejszyc biegu");
        }
    }

    @Override
    public int getBieg() {
        return obecnyBieg;
    }
}
