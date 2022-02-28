package com.wons.englishwordmanager.values;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WordList {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int listId;
    public String date;

    WordList(String date) {
        this.date = date;
    }
}
