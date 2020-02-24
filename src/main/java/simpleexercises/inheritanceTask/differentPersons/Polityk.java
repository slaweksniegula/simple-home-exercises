package simpleexercises.inheritanceTask;

public class Polityk extends Osoba {

    String partia;

    public Polityk(String imię, String nazwisko, int wiek, String partia) {
        super(imię, nazwisko, wiek);
        this.partia = partia;
    }

    public void setPartia(String partia) {
        this.partia = partia;
    }

    public String getPartia() {
        return partia;
    }
    public void opis(){
        super.opis();
        System.out.println("Jestem politykiem partii: " + getPartia());
    }
}
