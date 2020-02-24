package simpleexercises.inheritanceTask;

public class Osoba {

    private String imię;
private String nazwisko;
private int wiek;

    public Osoba(String imię, String nazwisko, int wiek) {
        this.imię = imię;
        this.nazwisko = nazwisko;
        this.wiek = wiek;
    }

    public void setImię(String imię) {
        this.imię = imię;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public String getImię() {
        return imię;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public int getWiek() {
        return wiek;
    }

    public void opis(){
        System.out.printf("Nazywam się  %s %s.\n",imię, nazwisko);
    }
}
