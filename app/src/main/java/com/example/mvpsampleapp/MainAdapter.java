package com.example.mvpsampleapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvpsampleapp.data.Note;
import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<NoteViewHolder> {
    private Context context;
    private List<Note> noteList;

    public MainAdapter() {

    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.item_note,
                parent,
                false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        Note note = noteList.get(position);
        holder.txtId.setText(note.getName());
        holder.txtNote.setText(String.valueOf(note.getId()));
    }

    @Override
    public int getItemCount() {
        return noteList.size();
    }


    @SuppressLint("NotifyDataSetChanged")
    public void updateData(List<Note> noteList) {
        this.noteList = noteList;
        notifyDataSetChanged();
    }
}


class NoteViewHolder extends RecyclerView.ViewHolder {
    MaterialTextView txtId;
    MaterialTextView txtNote;

    public NoteViewHolder(@NonNull View itemView) {
        super(itemView);
        txtId = itemView.findViewById(R.id.noteIdTextView);
        txtNote = itemView.findViewById(R.id.noteTextView);
    }
}
