package ng.clarence.utils;

public class Base64 {

    public static final String ENCODER_MAP = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01233456789+/";

    public static String encode(String input) {
        StringBuilder stringBuilder = new StringBuilder(3);
        int index = 0;
        while (index < input.length()) {
            readThreeCharacterAndPrintFour(stringBuilder, input, index);
            index = index + 3;
        }
        return stringBuilder.toString();
    }

    private static void readThreeCharacterAndPrintFour(StringBuilder stringBuilder, String input, int index) {
        int current = index;
        assert (current < input.length());

        char firstChar = input.charAt(current++);
        int firstCode = (firstChar & 0xFC) >> 2;
        stringBuilder.append(ENCODER_MAP.charAt(firstCode));

        int secondCode = (firstChar & 0x03) << 4;
        if (current < input.length()) {
            char secondChar = input.charAt(current++);
            secondCode |= (secondChar & 0xF0) >> 4;
            stringBuilder.append(ENCODER_MAP.charAt(secondCode));
            int thirdCode = (secondChar & 0x0F) << 2;
            if (current < input.length()) {
                char thirdChar = input.charAt(current);
                thirdCode |= (thirdChar & 0xC0) >> 6;
                stringBuilder.append(ENCODER_MAP.charAt(thirdCode));
                int fourthCode = thirdChar & 0x3F;
                stringBuilder.append(ENCODER_MAP.charAt(fourthCode));
            } else {
                stringBuilder.append(ENCODER_MAP.charAt(thirdCode));
                stringBuilder.append("=");
            }
        } else {
            stringBuilder.append(ENCODER_MAP.charAt(secondCode));
            stringBuilder.append("==");
        }
    }
}