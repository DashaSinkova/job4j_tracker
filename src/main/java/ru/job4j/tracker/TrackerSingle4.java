package ru.job4j.tracker;
/**
 * 1. Singleton.[#188304]
 */
public class TrackerSingle4 {
    private TrackerSingle4() {

    }
    public static MemTracker getInstance() {
        return Holder.INSTANCE;
    }
    private static final class Holder {
        private static final MemTracker INSTANCE = new MemTracker();
    }

}
