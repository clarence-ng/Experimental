package ng.clarence.utils;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

public class LoggerUtils {
    public static void printToStdOut(Logger logger, Level level) {
        StreamHandler streamHandler = new StreamHandler(System.out, new SimpleFormatter());
        streamHandler.setLevel(level);
        logger.addHandler(streamHandler);
        logger.setLevel(level);
    }
}
