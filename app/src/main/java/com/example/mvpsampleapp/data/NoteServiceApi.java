package com.example.mvpsampleapp.data;

import java.util.List;

public interface NoteServiceApi {
    List<Note> addNote(Note note);

    List<Note> removeNote(Note note);

    List<Note> getAllNotes();

    List<Note> removeAllNotes();


}
