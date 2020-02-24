package simpleexercises.loops;

import java.util.Random;
import java.util.Scanner;

//1. Napisz program, który wylosuje liczbę z przedziału 0-10. Następnie pytaj użytkownika o podanie liczby.
// Jeśli podana liczba jest większa niż wylosowana, wyświetl komunikat "Nie zgadłeś, spróbuj z mniejszą liczbą",
// podobnie jeśli podana liczba jest mniejsza od wylosowanej. Jeśli użytkownik poda prawidłową liczbę, wyświetl "Gratulacje! Zgadłeś!"
//        2. Napisz program, który zapyta o 4 liczby:
//        - x - początek prostokąta w poziomie (odległość od początku linii w spacjach)
//        - y - początek prostokąta w pionie (ilość nowych linii od góry)
//        - w (width) - szerokość prostokąta (ile 'x' narysować w poziomie)
//        - h (height) - wysokość prostąta (ile 'x' narysować w pionie)
//        Dla (2,3,4,5) powinien narysować:
//        ```bash
//>__
//>__
//>__
//>__xxxx
//>__xxxx
//>__xxxx
//>__xxxx
//>__xxxx
//```
//        3. Napisz program, który dla podanej przez użytkownika liczby sprawdzi, czy liczba ta jest liczbą pierwszą.
public class loops {
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
            System.out.print("Zgadnij liczbę od 0 do 10:"+ generatedInt);
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
