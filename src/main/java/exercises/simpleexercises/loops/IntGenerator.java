package exercises.simpleexercises.loops;

import java.util.Random;
import java.util.Scanner;

//1. Napisz program, który wylosuje liczbę z przedziału 0-10. Następnie pytaj użytkownika o podanie liczby.
// Jeśli podana liczba jest większa niż wylosowana, wyświetl komunikat "Nie zgadłeś, spróbuj z mniejszą liczbą",
// podobnie jeśli podana liczba jest mniejsza od wylosowanej. Jeśli użytkownik poda prawidłową liczbę, wyświetl "Gratulacje! Zgadłeś!"

//```

public class IntGenerator {
    public static void main(String[] args) {
        guessingInteger();
    }

    public static int intGenerator() {
        int generatedInt;
        Random random = new Random();
        generatedInt = random.nextInt(10);
        return generatedInt;
    }

    public static void guessingInteger() {

        int userInt;
        int generatedInt = intGenerator();

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Zgadnij liczbę od 0 do 10:");
            userInt = scanner.nextInt();
            while (userInt != generatedInt) {
                if (userInt > generatedInt) {
                    System.out.print("Twoja cyfra jest za duża. Zgaduj dalej: ");
                    userInt = scanner.nextInt();
                } else {
                    System.out.print("Twoja cyfra jest za mała. Zgaduj dalej: ");
                    userInt = scanner.nextInt();
                }
            }
            System.out.println("Gratuluję, zgadłeś.");

        } catch (
                Exception e) {
            System.out.println("Nie podałeś poprawnej cyfry.");
        }
    }
}
