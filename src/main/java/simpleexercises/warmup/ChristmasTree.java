package simpleexercises.warmup;

public class christmasTree {
    public static void main(String[] args) {
        System.out.println("    *    ");
        System.out.println("   ***   ");
        System.out.println("  *****  ");
        System.out.println(" ******* ");
        System.out.println("*********");
        System.out.println("   ***   ");
        System.out.println("   ***   ");
        printChristmasTree(5);
    }

    public static void printChristmasTree(int n) {
        for (int i = 0; i < n; i++) {
            char[] row = new char[(n - 1) * 2 + 1];
            fillWithSpaces(row);
            int firstStarIndex = (n - 1) -i;
            int numStars = (i * 2) + 1;
            for (int j = firstStarIndex; j < firstStarIndex + numStars ; j++) {
                row[j] = '*';
            }
            System.out.println(String.valueOf(row));
        }

    }

    private static void fillWithSpaces(char[] row) {
        for (int i = 0; i < row.length; i++) {
            row[i] = ' ';

        }
    }
}
