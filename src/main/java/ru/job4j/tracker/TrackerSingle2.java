package ru.job4j.tracker;

/**
 * 1. Singleton.[#188304]
 */
public enum  TrackerSingle2 {
    INSTANCE;
    private final MemTracker instance = new MemTracker();
    public MemTracker getInstance() {
        return instance;
    }
}
