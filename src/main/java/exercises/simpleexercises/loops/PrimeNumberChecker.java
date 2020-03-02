package exercises.simpleexercises.loops;

import java.util.Scanner;

//        3. Napisz program, który dla podanej przez użytkownika liczby sprawdzi, czy liczba ta jest liczbą pierwszą.
public class PrimeNumberChecker {
    public static void main(String[] args) {

        int userInt;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj swoją liczbę: ");
        userInt = scanner.nextInt();
        for (int i = 2; i < userInt; i++) {
            if (userInt % i == 0) {
                System.out.println("Twoja liczba nie jest liczbą pierwszą.");
                break;
            } else {
                System.out.println("Twoja liczba jest liczbą pierwszą.");
                break;
            }
        }
    }
}
