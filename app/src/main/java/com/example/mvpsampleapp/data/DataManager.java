package com.example.mvpsampleapp.data;

import java.util.ArrayList;
import java.util.List;

public class DataManager implements NoteServiceApi {
    private static DataManager instance;
    private List<Note> noteList;

    private DataManager() {
        noteList = new ArrayList<>();
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    @Override
    public List<Note> addNote(Note note) {
        noteList.add(note);
        return noteList;
    }

    @Override
    public List<Note> removeNote(Note note) {
        noteList.remove(note);
        return noteList;
    }

    @Override
    public List<Note> getAllNotes() {
        return noteList;
    }

    @Override
    public List<Note> removeAllNotes() {
        noteList.clear();
        return noteList;
    }

   public int getNoteListSize() {
        return noteList.size();
    }

}
