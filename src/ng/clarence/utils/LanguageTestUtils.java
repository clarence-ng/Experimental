package ng.clarence.utils;


import java.util.ArrayList;
import java.util.Arrays;

public class LanguageTestUtils {
    public static void test() {
        Integer[] vertices = new Integer[10];
        vertices[1] = 2;
        new ArrayList<>(Arrays.asList(vertices)).stream().forEach(System.out::print);
    }
}
