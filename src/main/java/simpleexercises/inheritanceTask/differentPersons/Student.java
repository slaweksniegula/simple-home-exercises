package simpleexercises.inheritanceTask;

public class Student extends Osoba {

    private String uczelnia;
    private String nrIndeksu;

    public Student(String imię, String nazwisko,int wiek, String uczelnia, String nrIndeksu) {
        super(imię, nazwisko, wiek);
        this.uczelnia = uczelnia;
        this.nrIndeksu = nrIndeksu;
    }

    public void setUczelnia(String uczelnia) {
        this.uczelnia = uczelnia;
    }

    public void setNrIndeksu(String nrIndeksu) {
        this.nrIndeksu = nrIndeksu;
    }

    public String getUczelnia() {
        return uczelnia;
    }

    public String getNrIndeksu() {
        return nrIndeksu;
    }

    public void opis(){
        super.opis();
        System.out.println("Jestem studentem uczelni " + getUczelnia() + "a mój nr indeksu to: "+ getNrIndeksu() );
    }
}
