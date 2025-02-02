package ru.job4j.tracker;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static org.hamcrest.core.Is.*;
import static org.junit.Assert.*;
public class StartUiInitTest {
    @Test
    public void whenExit() {
        StubInput input = new StubInput(new String[]{"0"});
        StubAction action = new StubAction();
        List<UserAction> list = new ArrayList<>();
        list.add(action);
        new StartUI().init(input, new MemTracker(), list);
        assertThat(action.isCall(), is(true));
    }
    @Test
    public void whenPrtMenu() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));
        StubInput input = new StubInput(new String[]{"0"});
        StubAction action = new StubAction();
        List<UserAction> list = new ArrayList<>();
        list.add(action);
        new StartUI().init(input, new MemTracker(), list);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add(System.lineSeparator() + "Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }
}
