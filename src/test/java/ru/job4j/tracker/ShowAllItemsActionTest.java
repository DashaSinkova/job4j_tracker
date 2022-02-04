package ru.job4j.tracker;
import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ShowAllItemsActionTest {
    /**
     *   заменяем стандартный вывод в консоль на вывод в память
     */
    @Test
    public void whenCheckOutput() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        MemTracker tracker = new MemTracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        ShowAllitemsAction act = new ShowAllitemsAction();
        act.execute(new StubInput(new String[]{}), tracker);
        String expect = item.toString() + System.lineSeparator();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
