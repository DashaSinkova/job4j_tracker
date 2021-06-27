package ru.job4j.tracker;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FindItemsByNameActionTest {
    @Test
    public void whenCheckOut() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        MemTracker tracker = new MemTracker();
        Item item = new Item("Dasha");
        Item item1 = new Item("Dasha");
        tracker.add(item);
        tracker.add(item1);
        FindItemsByNameAction act = new FindItemsByNameAction();
        act.execute(new StubInput(new String[]{"Dasha"}), tracker);
        String expect = " Successful! " + System.lineSeparator()+ item + System.lineSeparator() + item1 + System.lineSeparator();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
