package com.wons.englishwordmanager.values;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Word {
    @PrimaryKey
    @NonNull
    public String english;
    public String korean;
    public String listName;
    private int correctTimes;
    private int testTimes;
    public Word(String korean, String english, String listName) {
        this.korean = korean;
        this.english = english;
        this.listName = listName;
    }

    public int getCorrectTimes() {
        return correctTimes;
    }

    public int getTestTimes() {
        return testTimes;
    }

    public void setCorrectTimes(int correctTimes) {
        this.correctTimes = correctTimes;
    }

    public void setTestTimes(int testTimes) {
        this.testTimes = testTimes;
    }

}
