package it.polarorb.dynamo;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by erikrahtjen on 10/18/16.
 */
public class Logger {
    private static Logger sharedInstance;
    private static final int MAX_NUMBER_OF_MESSAGES_IN_HISTORY = 10;

    private final ArrayList<String> stringList = new ArrayList<String>();

    private Logger() {
        super();
    }

    public static Logger getSharedInstance() {
        if (sharedInstance == null) {
            sharedInstance = new Logger();
        }
        return sharedInstance;
    }

    private void recordMessage(String message, Class<? extends Object> originClass) {
        stringList.add(new Date(System.nanoTime()) + originClass.getClass().getSimpleName() + message);

        if (stringList.size() > MAX_NUMBER_OF_MESSAGES_IN_HISTORY) {
            stringList.remove(0);
        }
    }

    public static void log(String message, Class<? extends Object> originClass) {
        Logger.getSharedInstance().recordMessage(message, originClass);
    }
}
