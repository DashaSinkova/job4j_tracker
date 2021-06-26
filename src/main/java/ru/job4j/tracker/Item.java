package ru.job4j.tracker;

import java.time.LocalDateTime;

public class Item {
    private String id;
    private String name;
    private LocalDateTime created = LocalDateTime.now();
    public Item(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setId(String id) {
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
        return name;
    }
}
