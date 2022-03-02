package com.wons.englishwordmanager;

import android.content.Context;

import androidx.lifecycle.ViewModel;
import androidx.room.Room;

public class MainViewModel extends ViewModel {
    private static MainDataBase dataBase;
    public static MyDao dao;
    public void dataBaseBuild(Context context) {
        dataBase = Room.databaseBuilder(context, MainDataBase.class, "MainDataBase").allowMainThreadQueries().build();
        dao = dataBase.getDao();
    }
}
