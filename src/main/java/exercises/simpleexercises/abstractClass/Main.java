package exercises.simpleexercises.abstractClass;

public class Main {
    public static void main(String[] args) {

        UrzadzenieAgd[] urzadzenia= {
                new Lodowka("Philips", 80,"A++", -6,-6),
                new PlytaIndukcyjna("AEG",20,"A++",4,true),
                new Piekarnik("Samsung",30, "A+",300, true)
        } ;
        for(UrzadzenieAgd urzadzenie: urzadzenia){
            urzadzenie.opis();
        }
        System.out.println();
    }
}
