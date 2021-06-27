package ru.job4j.tracker;

/**
 * 1. Singleton.[#188304]
 */
public class TrackerSingle1 {
    private static MemTracker instance;

    private TrackerSingle1() {

    }
    public static MemTracker getInstance() {
        if (instance == null) {
            instance = new MemTracker();
        }
        return instance;
    }
}
