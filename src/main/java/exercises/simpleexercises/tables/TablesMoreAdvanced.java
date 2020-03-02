package exercises.simpleexercises.tables;

import java.util.Scanner;

//        2. Utwórz metodę pobierającą dodatnią liczbę całkowitą X, która wyświetli na ekranie liczby od zera do X,
//        3. Zrób to samo używając pętli while oraz do while

public class TablesMoreAdvanced {
    public static void main(String[] args) {
        int tablicaLiczbCalkowitych [] = {6,7,3,5,9,6,3,1,23,45,67,78,89};

showIntegersFromZeroToXWithWhile();
        System.out.println();
showIntegersFromZeroToXWithDoWhile();
    }

    public static void showIntegersFromZeroToXWithWhile(){
        int integersFromZeroToX = 0;
        int userInteger;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj cyfrę całkowitą i dodatnią : ");
        userInteger = scanner.nextInt();
        try {
            while (integersFromZeroToX <= userInteger) {
                if (integersFromZeroToX < userInteger) {
                    System.out.print(integersFromZeroToX + ", ");
                } else {
                    System.out.print(integersFromZeroToX + ".");
                }
                integersFromZeroToX++;
            }
        }catch (Exception e){
            System.out.println("Podałeś niewłaściwą liczbę.");
        }
    }
    public static void showIntegersFromZeroToXWithDoWhile(){
        int integersFromZeroToX = 0;
        int userInteger;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj cyfrę całkowitą i dodatnią : ");
        userInteger = scanner.nextInt();
        try {
            do {
                if (integersFromZeroToX < userInteger) {
                System.out.print(integersFromZeroToX + ", ");
            } else {
                System.out.print(integersFromZeroToX + ".");
            }
                integersFromZeroToX++;
            }while (integersFromZeroToX<=userInteger);
        }catch (Exception e){
            System.out.println("Podałeś błędną cyfrę.");
        }
    }
}
