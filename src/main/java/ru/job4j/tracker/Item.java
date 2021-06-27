package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {
    private int id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    public Item(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("id: %s, name: %s, created: %s", id, name, created.format(FORMATTER)) + System.lineSeparator();
    }
}
