package exercises.simpleexercises.inheritanceTask.bike;

import exercises.simpleexercises.inheritanceTask.bike.hamulec.HamulecVBrake;
import exercises.simpleexercises.inheritanceTask.bike.hamulec.HamulecZwykly;
import exercises.simpleexercises.inheritanceTask.bike.przerzutka.Przerzutka8Biegowa;
import exercises.simpleexercises.inheritanceTask.bike.przerzutka.Przerzutka9biegowa;
import exercises.simpleexercises.inheritanceTask.bike.rama.RamaAluminiowa;
import exercises.simpleexercises.inheritanceTask.bike.rama.RamaMetalowa;

public class Main {
    public static void main(String[] args) {


        Rower rower1 = new Rower(new HamulecZwykly(),new Przerzutka8Biegowa(2),new RamaMetalowa());
        Rower rower2 = new Rower(new HamulecVBrake(), new Przerzutka9biegowa(3), new RamaAluminiowa());


        System.out.println("Prędkość roweru 1 wynosi: " + rower1.getMaksymalnaPredkosc() +
                " a jego droga hamowania to: " + rower1.obliczDrogeHamowania());
    }
}
