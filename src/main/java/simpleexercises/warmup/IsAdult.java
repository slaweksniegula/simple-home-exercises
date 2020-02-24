package simpleexercises.warmup;

import java.util.Scanner;

//1. Napisz metodę, która sprawdza pełnoletność danej osoby. Zastanów się nad sygnaturą metody,
// następnie ją zaimplementuj i uruchom dla kilku wartości.
public class isAdult {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Podaj swój wiek: ");
            int wiek = scanner.nextInt();
            if (wiek < 0) {
                System.out.print("Wiek nie może być ujemny. Podaj właściwy wiek:");
                wiek = scanner.nextInt();
            } else if (wiek >= 18) {
                System.out.println("Jesteś pełnoletni");
            } else {
                System.out.println("Jesteś niepełnoletni");
            }
        }catch(Exception e){
            System.out.println("Musisz podać liczbę całkowitą");
        }
    }
}


