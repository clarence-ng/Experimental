package ng.clarence.utils;

import java.io.PrintStream;

public class CharUtils {

    private static void printCharAsBinary(int c, PrintStream out) {
        String b = Integer.toBinaryString(c);
        if (b.length() < 8) {
            b = "000000000".substring(0, 8 - b.length()).concat(b);
        } else {
            b = b.substring(b.length() - 8);
        }
        out.print(b);
    }
}
