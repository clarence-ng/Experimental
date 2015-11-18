package ng.clarence.collections;

import java.util.LinkedList;

public class Permutations {

    public static void permuteCharactersOfString(String prefix, String s, LinkedList<String> answer) {
        if (s.length() == 0) {
            answer.add(prefix.toString());
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            permuteCharactersOfString(prefix + c, s.substring(0, i) + s.substring(i + 1, s.length()), answer);
        }
    }
}
