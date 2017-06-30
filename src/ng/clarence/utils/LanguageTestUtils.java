package ng.clarence.utils;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class LanguageTestUtils {
    public static void test() {
        Integer[] vertices = new Integer[10];
        vertices[1] = 2;
        new ArrayList<>(Arrays.asList(vertices)).stream().forEach(System.out::print);

        doRecursion(System.out::println);
        Optional<Node> oT = Optional.empty();
        System.out.println(oT.map(Node::getHeight).orElse(0));
        System.out.println(Optional.of(new Node(2)).map(Node::getHeight).orElse(0));
    }

    public static void doRecursion(PostProcessor<String> postProcessor) {
        postProcessor.process("haha");
    }

    interface PostProcessor<T> {
        void process(T value);
    }

    static class Node {
        private final int height;

        Node(int height) {
            this.height = height;
        }

        public int getHeight() {
            return height;
        }
    }
}
