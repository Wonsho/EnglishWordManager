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
    public int passedCount = 0;
    public int testCount = 0;

    public WordList(String date) {
        this.date = date;
    }

    public void clearCount() {
        this.passedCount = 0;
        this.testCount = 0;
    }
}
