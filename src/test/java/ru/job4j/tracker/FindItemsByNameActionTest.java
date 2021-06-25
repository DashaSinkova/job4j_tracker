package ru.job4j.tracker;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

public class FindItemsByNameActionTest {
    @Test
    public void whenCheckOut() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        Tracker tracker = new Tracker();
        Item item = new Item("Dasha");
        Item item1 = new Item("Dasha");
        tracker.add(item);
        tracker.add(item1);
        FindItemsByNameAction act = new FindItemsByNameAction();
        act.execute(new StubInput(new String[]{"Dasha"}), tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(" Successful! ")
                .add((item.getId() + " " + item.getName()))
                .add((item1.getId() + " " + item1.getName()))
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
