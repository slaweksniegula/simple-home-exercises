package exercises.simpleexercises.methods;
//5. Napisz metodę, która przyjmie w argumencie liczbę i zwróci `true` jeśli liczba jest parzysta.
//        6. Napisz metodę, która przyjmie w argumencie liczbę i zwróci `true` jeśli liczba jest podzielna przez 3 i przez 5.
//        7. Napisz metodę, która przyjmie w argumencie liczbę zmiennoprzecinkową (double) i zwróci jej pierwiastek kwadratowy. Znajdź w internecie, jak to zrobić korzystając klasy `Math`
public class SimpleMethods {

    public static void main(String[] args) {
evenNumberChecker(12);
divByThreeAndFiveChecker(15);
        System.out.println(getSquareRoot(4));
    }

    public static void evenNumberChecker( int number){
//        System.out.println(number%2==0);
        if (number%2==0){
            System.out.println("true");
        }
    }

    public static void divByThreeAndFiveChecker(double number){
        if(number % 3 == 0 && number % 5 == 0){
            System.out.println("true");
        }
    }

    public static double getSquareRoot(double number){
        double squareRoot;
        squareRoot = Math.sqrt(number);
        return squareRoot;
    }
}
