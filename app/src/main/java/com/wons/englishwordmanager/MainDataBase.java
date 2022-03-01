package com.wons.englishwordmanager;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.wons.englishwordmanager.MyDao;
import com.wons.englishwordmanager.values.Word;
import com.wons.englishwordmanager.values.WordList;

@Database(entities = {WordList.class, Word.class}, version = 1)
public abstract class MainDataBase extends RoomDatabase {
    abstract public MyDao getDao();
}
