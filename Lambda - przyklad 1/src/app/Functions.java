package app;

import java.util.function.Function;
 
public class Functions {
    public static void main(String[] args) {
        //funkcja przyjmuje String i zwraca String
        Function<String, String> func = (String str) -> str.toLowerCase().trim();
        String original = "   WIELKI NAPIS   ";
        //wywołujemy funkcję przekazując jej original jako argument
        String lowerCaseTrim = func.apply(original);
        System.out.println(original);
        System.out.println(lowerCaseTrim);
    }
}