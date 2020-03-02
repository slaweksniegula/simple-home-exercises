package exercises.simpleexercises.loops;

import java.util.Scanner;

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
public class DrawingObject {
    public static void main(String[] args) {
        int horizontalStart;
        int verticalStart;
        int high;
        int width;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj 4 cyfry. Początek prostokonta w poziomie: ");
        horizontalStart = scanner.nextInt();
        System.out.println("Początek prostokonta w pionie: ");
        verticalStart = scanner.nextInt();
        System.out.println("Szerokość prostokonta: ");
        width = scanner.nextInt();
        System.out.println("Wysokość prostokonta: ");
        high = scanner.nextInt();

        for (int i = 0; i < verticalStart + high; i++) {
            for (int j = 0; j < horizontalStart; j++) {
                System.out.print("_");
            }if (i >= verticalStart) {
                for (int k = 0; k < high; k++) {
                    System.out.print("x");
                }
            }
            System.out.println();
        }
    }
}
