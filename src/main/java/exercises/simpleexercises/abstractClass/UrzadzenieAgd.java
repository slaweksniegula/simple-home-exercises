package exercises.simpleexercises.abstractClass;

public abstract class UrzadzenieAgd {
    String nazwa;
    int ciężar;
    String klasaEnergetyczna;

    public UrzadzenieAgd(String nazwa, int ciężar, String klasaEnergetyczna) {
        this.nazwa = nazwa;
        this.ciężar = ciężar;
        this.klasaEnergetyczna = klasaEnergetyczna;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getCiężar() {
        return ciężar;
    }

    public String getKlasaEnergetyczna() {
        return klasaEnergetyczna;
    }

    abstract void opis();
}
