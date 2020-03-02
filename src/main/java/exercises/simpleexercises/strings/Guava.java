package exercises.simpleexercises.strings;


import com.google.common.base.Joiner;


import java.util.StringJoiner;

public class Guava {

    public static void main(String[] args) {

        String[] strings = {"Ala", "ma", "kota."};
        char[] chars = {'a', 'l', 'a', 'm', 'a', 'k', 'o', 't', 'a'};

        joinByJoiner(strings);
        joinByGuava(strings);
        System.out.println();
        joinChar(chars);
    }


    public static void joinByGuava(String[] strings) {
//import Guava in Maven and comment StringJoiner import
        Joiner joiner = Joiner.on(" ");
        String sentence = joiner.join(strings);
        System.out.println(sentence);
    }


    public static void joinByJoiner(String[] strings) {
        StringJoiner join = new StringJoiner(" ", "[", "]");
        String merged = null;
        for (int i = 0; i < strings.length; i++) {
            merged = join.add(strings[i]).toString();
        }
        System.out.println(merged);
    }

    public static void joinChar(char[] chars) {

        StringBuilder stringBuilder = new StringBuilder();
        for (char c : chars) {
            if (c == 'a') {
                stringBuilder.append(c + " ");
            } else {
                stringBuilder.append(c);
            }
        }
        String sentence = stringBuilder.toString();
        System.out.println(sentence);
    }
}
