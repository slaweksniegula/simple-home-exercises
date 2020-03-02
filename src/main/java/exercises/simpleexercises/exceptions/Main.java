package exercises.simpleexercises.exceptions;

public class Main {
    public static void main(String[] args) {
        try {
            User user1 = new User("Piotr", "piotr.com");
            System.out.println(user1);
        } catch (EmailFormatExeption e) {
            System.out.println("Nastapil wyjatek, wiadomosc: " + e.getMessage());
        } catch (NameFormatExeption e) {
            System.out.println("Nastąpił wyjątek " + e.getMessage());
        }

        try {
            User user2 = new User("piotr", "piotr@lp.com");
            System.out.println(user2);
        } catch (EmailFormatExeption e) {
            System.out.println("Nastapil wyjatek, wiadomosc: " + e.getMessage());
        } catch (NameFormatExeption e) {
            System.out.println("Nastąpił wyjątek " + e.getMessage());

        }
    }
}
