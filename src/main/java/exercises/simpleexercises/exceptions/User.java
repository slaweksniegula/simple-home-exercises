package exercises.simpleexercises.exceptions;

public class User {

    private String name;
    private String email;

    public User(String name, String email) throws NameFormatExeption, EmailFormatExeption {
        if (isNameOk(name)) {
            this.name = name;
        } else {
            throw new NameFormatExeption("Imię powinno zaczynać się z wielkiej litery");
        }

        if (isEmailOk(email)) {
            this.email = email;
        } else {
            throw new EmailFormatExeption("Email nie zawiera @");
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    private boolean isNameOk(String name) {
        char pierwszaLitera = name.charAt(0);
        if ((pierwszaLitera > 65) && (pierwszaLitera <= 90)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEmailOk(String email) {
        if (email.contains("@")) {
            return true;
        } else {
            return false;
        }
    }
}
