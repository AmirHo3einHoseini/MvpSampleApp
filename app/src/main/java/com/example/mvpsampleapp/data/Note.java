package com.example.mvpsampleapp.data;

import java.util.Objects;

public class Note {
    private final int id;
    private final String name;

    public Note(String name, int id) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Note note = (Note) o;
        return id == note.id && Objects.equals(name, note.name);
    }

    @Override
    public int hashCode() {
        return id * 53;
    }
}
