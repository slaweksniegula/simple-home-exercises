package exercises.simpleexercises.tables;


import java.util.Scanner;

//        4. Utwórz klasę MatrixFactory, która dla zadanego N zwróci tablicę dwuwymiarową o rozmiarze N x N elementów typu int.
//        5. Do powyższej klasy dodaj metodę getIdentityMatrix, która zwróci macierz jednostkową (powinna mieć wszędzie zera, ale na przekątnej jedynki)przekątnej

public class MatrixFactory {
    public static void main(String[] args) {
        matrixFactory();
        System.out.println();
        getIdentityMatrix();
    }

    public static void matrixFactory() {
        int dimentionsOfMatrix;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wymiar tablicy \"N\"=  ");
        dimentionsOfMatrix = scanner.nextInt();
        int newMatrix[][] = new int[dimentionsOfMatrix][dimentionsOfMatrix];
        for (int row = 0; row < newMatrix.length; row++) {
            for (int col = 0; col < newMatrix.length; col++) {
                System.out.print(newMatrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    public static void getIdentityMatrix(){
        int dimentionsOfMatrix;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj wymiar tablicy:");
        dimentionsOfMatrix = scanner.nextInt();

        int [][] newMatrix = new int[dimentionsOfMatrix][dimentionsOfMatrix];
        for (int row = 0; row < newMatrix.length; row++) {
            for (int col = 0; col < newMatrix.length; col++) {
                if( row == col){
                    newMatrix[row][col] = 1;
                }else{
                    newMatrix[row][col] = 0;
                }
                System.out.print(newMatrix[row][col]);
            }
            System.out.println();
        }
    }
}

