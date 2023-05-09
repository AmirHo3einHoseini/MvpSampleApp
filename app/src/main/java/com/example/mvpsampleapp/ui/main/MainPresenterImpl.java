package com.example.mvpsampleapp.ui.main;

import com.example.mvpsampleapp.data.DataManager;
import com.example.mvpsampleapp.data.Note;

public class MainPresenterImpl implements MainContract.Presenter {
    private final MainContract.View view;
    private final DataManager dataManager;

    public MainPresenterImpl(MainContract.View view, DataManager dataManager) {
        this.view = view;
        this.dataManager = dataManager;
        view.setPresenter(this);
    }


    @Override
    public void addNote(String note) {
        if (note != null && note.length() > 0)
            view.updateView(
                    dataManager.addNote(
                            new Note(
                                    note
                                    ,dataManager.getNoteListSize() + 1 )));
    }

    @Override
    public void removeNote(Note note) {
        view.updateView(dataManager.removeNote(note));
    }

    @Override
    public void getAllNotes() {
        view.updateView(dataManager.getAllNotes());
    }

    @Override
    public void clearAll() {
        view.updateView(dataManager.removeAllNotes());
    }
}
