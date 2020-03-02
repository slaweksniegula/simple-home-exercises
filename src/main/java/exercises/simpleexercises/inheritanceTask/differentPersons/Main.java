package exercises.simpleexercises.inheritanceTask.differentPersons;

public class Main {
    public static void main(String[] args) {

        Osoba jan = new Polityk("Jan", "Kowalski", 45, "PO");
        Osoba marcin = new Polityk("Marcin", "Nowak", 54, "PIS");
        Osoba krzysztof = new Student("Krzysztof", "Nowicki", 22, "UKW", "A126353");

        Osoba[] wszystkieOsoby = {jan, marcin, krzysztof};

        for (Osoba o : wszystkieOsoby) {
            o.opis();
            System.out.println();
        }
    }
}
