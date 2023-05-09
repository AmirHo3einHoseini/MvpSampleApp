package com.example.mvpsampleapp.ui.main;

import com.example.mvpsampleapp.data.Note;
import com.example.mvpsampleapp.ui.MvpPresenter;
import com.example.mvpsampleapp.ui.MvpView;

import java.util.List;

public interface MainContract {
    interface View extends MvpView<Presenter> {
        void updateView(List<Note> noteList);
    }


    interface Presenter extends MvpPresenter {
        void addNote(String note);

        void removeNote(Note note);

        void getAllNotes();

        void clearAll();
    }
}
