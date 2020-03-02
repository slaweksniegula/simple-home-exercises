package exercises.simpleexercises.abstractClass;

public class PlytaIndukcyjna extends UrzadzenieAgd {

    int iloscPolIndukcyjnych;
    boolean booster;

    public PlytaIndukcyjna(String nazwa, int ciężar, String klasaEnergetyczna, int iloscPolIndukcyjnych, boolean booster) {
        super(nazwa, ciężar, klasaEnergetyczna);
        this.iloscPolIndukcyjnych = iloscPolIndukcyjnych;
        this.booster = booster;
    }

    public int getIloscPolIndukcyjnych() {
        return iloscPolIndukcyjnych;
    }

    public boolean isBooster() {
        return booster;
    }

    @Override
    void opis() {

        System.out.printf("%s, %d, %s, %d, %b \n", nazwa, ciężar, klasaEnergetyczna, iloscPolIndukcyjnych, booster);

    }
}
