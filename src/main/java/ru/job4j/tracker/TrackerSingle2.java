package ru.job4j.tracker;

/**
 * 1. Singleton.[#188304]
 */
public enum  TrackerSingle2 {
    INSTANCE;
    private final Tracker instance = new Tracker();
    public Tracker getInstance() {
        return instance;
    }
}
