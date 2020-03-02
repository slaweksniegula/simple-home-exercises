package exercises.simpleexercises.abstractClass;

public class Piekarnik extends UrzadzenieAgd {

    int maksymalnaTemp;
    boolean termoobieg;

    public Piekarnik(String nazwa, int ciężar, String klasaEnergetyczna, int maksymalnaTemp, boolean termoobieg) {
        super(nazwa, ciężar, klasaEnergetyczna);
        this.maksymalnaTemp = maksymalnaTemp;
        this.termoobieg = termoobieg;
    }

    public int getMaksymalnaTemp() {
        return maksymalnaTemp;
    }

    public boolean isTermoobieg() {
        return termoobieg;
    }

    @Override
    void opis() {
        System.out.println(nazwa+"," +ciężar+"," +klasaEnergetyczna+","+maksymalnaTemp+"," +termoobieg);
        System.out.printf("%s, %d, %s, %d, %b \n", nazwa, ciężar, klasaEnergetyczna, maksymalnaTemp, termoobieg);

    }
}
