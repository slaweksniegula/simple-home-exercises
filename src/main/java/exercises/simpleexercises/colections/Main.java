package exercises.simpleexercises.colections;

import java.util.*;

public class Main {

    public static void main(String[] args) {
//zad 1
        Person Adam = new Person("Adam", "Adamski", 18);
        Person Kinga = new Person("Kinga", "Kingowska", 23);
        Person Piotrek = new Person("Piotrek", "Piotrowski", 28);
        Person Julia = new Person("Julia", "juliowska", 32);
        Person Agnieszka = new Person("Agnieszka", "Agnieszkowska", 41);

        List<Person> allPeople = new ArrayList<>();
        allPeople.add(Adam);
        allPeople.add(Kinga);
        allPeople.add(Piotrek);
        allPeople.add(Julia);
        allPeople.add(Agnieszka);

        System.out.println(allPeople);
        for (int i = 0; i < allPeople.size(); i++) {
            System.out.println(allPeople.get(i));
        }

        //zad 6
        getDigits();

    }

    //zad 6
    public static void getDigits() {
        List<Integer> myList = new ArrayList<>();
        int[] integers = {4, 7, 8, 3, 4, 8, 7, 89, 12, 1, 1, 5};
        for (int i = 0; i < integers.length; i++) {
            myList.add(integers[i]);
        }
        System.out.println(myList);
        Set<Integer> myCollection = new TreeSet<>();

        for (Integer a : myList) {
            myCollection.add(a);
        }
        System.out.println(myCollection);
        Iterator iterator = myCollection.iterator();
        while (iterator.hasNext()) {
            System.out.printf("%d, ",iterator.next());
        }
    }
}

