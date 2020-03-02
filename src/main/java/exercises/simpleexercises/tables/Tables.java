package exercises.simpleexercises.tables;



//1. Dana jest tablica liczb całkowitych, wypisz:
//        - wszystkie po kolei
//        - wszystkie od końca
//        - wszystkie na nieparzystych pozycjach
//        - wszystkie podzielne przez 3
//        - sumę wszystkich
//        - sumę pierwszych 4
//        - sumę ostatnich 5 większych od 2
//        - ilość liczb idąc od początku tablicy, by ich suma przekroczyła 10
//        2. Utwórz metodę pobierającą dodatnią liczbę całkowitą X, która wyświetli na ekranie liczby od zera do X,
//        3. Zrób to samo używając pętli while oraz do while
//        4. Utwórz klasę MatrixFactory, która dla zadanego N zwróci tablicę dwuwymiarową o rozmiarze N x N elementów typu int.
//        5. Do powyższej klasy dodaj metodę getIdentityMatrix, która zwróci macierz jednostkową (powinna mieć wszędzie zera, ale na przekątnej jedynki)przekątnej
public class Tables {
    public static void main(String[] args) {

int tablicaLiczbCalkowitych [] = {6,7,3,5,9,6,3,1,23,45,67,78,89};
//        - wszystkie po kolei
        for (int value : tablicaLiczbCalkowitych){
            System.out.print(value + " ");
        }
        System.out.println();
//        - wszystkie od końca
        for (int i = tablicaLiczbCalkowitych.length -1; i >= 0 ; i--) {
            System.out.print(tablicaLiczbCalkowitych[i] + " ");
        }
        System.out.println();
//        - wszystkie na nieparzystych pozycjach
        for (int i = 0; i <tablicaLiczbCalkowitych.length ; i+=2) {
            System.out.print(tablicaLiczbCalkowitych[i] + " ");
        }
        System.out.println();
//        - wszystkie podzielne przez 3
        for (int value2 : tablicaLiczbCalkowitych){
            if (value2 % 3 == 0){
                System.out.print(value2 + " ");
            }
        }
        System.out.println();
//        - sumę wszystkich
        int sum = 0;
        for (int value3 : tablicaLiczbCalkowitych){
            sum+=value3;
        }
        System.out.println(sum);

//        - sumę pierwszych 4
        int sumOfFirstFour = 0;
        for (int i = 0; i < 4; i++) {
            sumOfFirstFour+= tablicaLiczbCalkowitych[i];

        }System.out.println(sumOfFirstFour + " ");

//        - sumę ostatnich 5 większych od 2
        int sumOfLastFiveLargerThan2=0;
        for (int i = tablicaLiczbCalkowitych.length - 1; i > tablicaLiczbCalkowitych.length -6 ; i--) {
            if (tablicaLiczbCalkowitych[i] > 2){
                sumOfLastFiveLargerThan2 += tablicaLiczbCalkowitych[i];
            }
        }
        System.out.println(sumOfLastFiveLargerThan2 + " ");

//        - ilość liczb idąc od początku tablicy, by ich suma przekroczyła 10
        int sumUntilPassingTen = 0;
        int numberOfIntegers = 0;
        for (int i = 0; i < tablicaLiczbCalkowitych.length; i++) {
            sumUntilPassingTen+= tablicaLiczbCalkowitych[i];
            numberOfIntegers+=1;
            if (sumUntilPassingTen> 10){
                break;
            }
        }
        System.out.println(numberOfIntegers);
    }

}
