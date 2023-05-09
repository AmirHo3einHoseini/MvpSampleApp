package com.example.mvpsampleapp.ui;

public interface MvpView<T extends MvpPresenter> {
    void setPresenter(T presenter);
}
