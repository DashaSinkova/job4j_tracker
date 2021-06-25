package ru.job4j.tracker;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
/**
 * 1. Singleton.[#188304]
 */
public class TrackerSingle2Test {
    @Test
    public void when1object() {
        Tracker tracker = TrackerSingle2.INSTANCE.getInstance();
        Tracker trackerTest = TrackerSingle2.INSTANCE.getInstance();
        tracker.add(new Item("Даша"));
        assertThat(tracker.findAll(), is(trackerTest.findAll()));
    }
}
