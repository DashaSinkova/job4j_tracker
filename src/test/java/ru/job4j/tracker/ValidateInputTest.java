package ru.job4j.tracker;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.*;

public class ValidateInputTest {
    @Test
    public void whenInvalidInput() {
        ByteArrayOutputStream mem = new ByteArrayOutputStream();
        PrintStream out = System.out;
        System.setOut(new PrintStream(mem));
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"one", "1"}));
        input.askInt("Enter");
        assertThat(mem.toString(), is(String.format("Please enter validate data again.") + System.lineSeparator()));
        System.setOut(out);

    }
}
