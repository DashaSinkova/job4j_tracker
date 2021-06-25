package ru.job4j.tracker;

/**
 * 1. Singleton.[#188304]
 */
public class TrackerSingle1 {
    private static Tracker instance;

    private TrackerSingle1() {

    }
    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}
