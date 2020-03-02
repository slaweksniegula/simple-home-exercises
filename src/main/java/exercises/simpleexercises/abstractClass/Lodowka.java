package exercises.simpleexercises.abstractClass;

public class Lodowka extends UrzadzenieAgd {

    int minTemp;
    int maxTemp;

    public int getMinTemp() {
        return minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public Lodowka(String nazwa, int ciężar, String klasaEnergetyczna, int minTemp, int maxTemp) {
        super(nazwa, ciężar, klasaEnergetyczna);
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    @Override
    void opis() {
        System.out.println(nazwa+"," +ciężar+"," +klasaEnergetyczna+","+maxTemp+"," +minTemp);
        System.out.printf("Nazwa %s, Ciężar %d, Kl. energ. %s,  maxTemp %d,  min. temp. %d \n", nazwa, ciężar, klasaEnergetyczna, maxTemp, minTemp);
    }
}
