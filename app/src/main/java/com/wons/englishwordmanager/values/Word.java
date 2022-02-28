package com.wons.englishwordmanager.values;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int wordId;

    public String korean;
    public String english;
    public String listCode;
    public int correctTimes;
    Word(String korean, String english, String listCode) {
        this.korean = korean;
        this.english = english;
        this.listCode = listCode;
    }
}
