package ng.clarence.solutions;

public class PrintWordsFromPhoneNumberPad {
    private static final byte[][] numberToListOfChars = {
        { 'a', 'b', 'c' },
        { 'd', 'e', 'f' },
        { 'g', 'h', 'i' },
        { 'j', 'k', 'l' },
        { 'm', 'n', 'o' },
        { 'p', 'q', 'r', 's' },
        { 't', 'u', 'v' },
        { 'w', 'x', 'y', 'z' },
    };

    public static void printWords(int[] numbers) {
        byte[] word = new byte[numbers.length];
        printWordsHelper(word, 0, numbers);
    }

    public static void printWordsHelper(byte[] currentWord, int index, int[] numbers) {
        if (index >= numbers.length) {
            System.out.println(new String(currentWord));
            return;
        }
        int number = numbers[index];
        for (byte ch : numberToListOfChars[number - 2]) {
            currentWord[index] = ch;
            printWordsHelper(currentWord, index+1, numbers);
        }
    }
}
