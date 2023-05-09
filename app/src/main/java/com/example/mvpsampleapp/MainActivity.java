package com.example.mvpsampleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.mvpsampleapp.data.Note;
import com.example.mvpsampleapp.databinding.ActivityMainBinding;
import com.example.mvpsampleapp.ui.main.MainContract;
import com.example.mvpsampleapp.ui.main.MainPresenterImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private ActivityMainBinding binding;
    private MainContract.Presenter presenter;
    private MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        new MainPresenterImpl(this, MvpApplication.get(this).getDataManager());

        binding.addNoteButton.setOnClickListener(view -> {
            presenter.addNote(String.valueOf(binding.noteEditText.getText()));
            binding.noteEditText.getText().clear();

        });
        mainAdapter = new MainAdapter();

        binding.noteRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.noteRecyclerView.setAdapter(mainAdapter);
        presenter.getAllNotes();

    }


    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void updateView(List<Note> noteList) {
        mainAdapter.updateData(noteList);
    }


}