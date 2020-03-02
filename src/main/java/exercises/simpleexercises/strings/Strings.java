package exercises.simpleexercises.strings;

import java.util.*;

//    1. Dana jest tablica napisów (String):
//        - napisz metodę, która zwróci losowy z nich (użyj Random.nextInt())
//        - napisz metodę, która sprawdzi, który ze stringów jest adresem email (załóżmy, że musi jedynie zawierać znak '@'), zwróć tablicę, która zawiera jedynie adresy email.
//        Niech tablica ma stałą wielkość - 5
//        - Napisz metodę, która sprawdzi, czy podane imię jest imieniem żeńskim - Zaczna się z wielkiej litery, ma co najmniej 3 znaki i kończy się na A, lub należy do podanej tablicy wyjątków - np {"Jess", "El"}
//    2. Napisz metodę, która sprawdza, czy dwa podane napisy są palindromem - tzn. czyta się je tak samo od tyłu jak od przodu. __UWAGA! ZADANIE REKRUTACYJNE__
//    3. Napisz metodę, która sprawdza, czy dwa podane napisy są anagramami - tzn. czy pierwszy składa się dokładnie z liter drugiego. __UWAGA! ZADANIE REKRUTACYJNE__
//    4. Napisz metodę, która przyjmuje String i zwraca jego "odwróconą" wartość, np. dla "Ala ma kota" zwróci "atok am alA'. Spróbuj to zrobić bez StringBuildera, a potem z.
//
public class Strings {


    public static void main(String[] args) {

        String[] tableOfStrings = {"Ala", "kot", "pies", "dinozaur", "rakiet", "marsjanin", "kosmos", "małpa@małpa.pl", "Marta", "enterprise", "startreck", "trecking", "góry", "Jess", "El"};
//        randomStringGenerator(tableOfStrings);
////        emailAddresChecker(tableOfStrings);
////        femaleNameChecker(tableOfStrings);
////        palindromChecker(tableOfStrings);
////        anagramChecker();
        getReverseString("Ala ma kota");
        getReverseStringWithStringBuilder("Ala ma kota");
    }

    public static void randomStringGenerator(String[] tableOfStrings) {
        Random random = new Random();
        int nbrOfRandomString = random.nextInt(tableOfStrings.length);
        System.out.println("Wylosowano string nr: " + nbrOfRandomString + " czyli :" + tableOfStrings[nbrOfRandomString]);
    }

    public static void emailAddresChecker(String[] tableOfStrings) {
        String[] emailAdresses = new String[5];
        int i = 0;
        for (String string : tableOfStrings) {
            if (string.contains("@")) {
                System.out.println(string + "jest adresem email");
                emailAdresses[i] = string;
            }
        }
        System.out.println(Arrays.toString(emailAdresses));
    }

    public static void femaleNameChecker(String[] tableOfStrings) {
        for (int i = 0; i < tableOfStrings.length; i++) {
            if (tableOfStrings[i].startsWith("".toUpperCase()) && tableOfStrings[i].length() >= 3 &&
                    tableOfStrings[i].endsWith("a") ||
                    tableOfStrings[i].contains("Jess") ||
                    tableOfStrings[i].contains("El")) {
                System.out.println(tableOfStrings[i] + " to imię żeńskie.");
            }
        }
    }

    public static void palindromChecker(String[] tableOfStrings) {

        for (int i = 0; i < tableOfStrings.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(tableOfStrings[i].toLowerCase());
            String reverse = stringBuilder.reverse().toString();
            if (tableOfStrings[i].toLowerCase().equals(reverse)) {
                System.out.println("Wyraz " + tableOfStrings[i] + " jest palindromem.");
            } else {
                System.out.println("Wyraz " + tableOfStrings[i] + " nie jest palindromem");
            }
        }
    }

    public static void anagramChecker() {
        String userString1;
        String userString2;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wyraz: ");
        userString1 = scanner.nextLine();
        System.out.println("Podaj wyraz 2: ");
        userString2 = scanner.nextLine();
        char[] chars = userString1.toCharArray();
        char[] chars2 = userString2.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chars2);
        if (userString1.length() != userString2.length()) {
            System.out.println("To nie anagramy");
        } else if (!Arrays.equals(chars, chars2)) {
            System.out.println("To nie anagramy");
        } else {
            System.out.println("To anagramy");
        }
    }

    public static void getReverseString (String string){
        String normalString = string;
        String reverseString;
        char [] charArrayFromString =  normalString.toCharArray();
        char[] reverseCharArray = new char[charArrayFromString.length];
        int count = 0;
        for (int i = charArrayFromString.length -1; i >= 0 ; i--) {
            reverseCharArray[count] = charArrayFromString[i];
            count++;
        }
        reverseString = String.valueOf(reverseCharArray);
        System.out.println(reverseString);
    }

    public static void getReverseStringWithStringBuilder(String string){
        String normalString = string;
        String reverseString;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(normalString);
        reverseString = stringBuilder.reverse().toString();
        System.out.println(reverseString);
    }
}