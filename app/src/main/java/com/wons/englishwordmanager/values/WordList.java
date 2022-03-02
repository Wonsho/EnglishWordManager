package com.wons.englishwordmanager.values;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WordList {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    public int listId;
    public String listName;
    private int wordCount = 0;
    private int passedCount = 0;
    private int testCount = 0;

    public WordList(String listName) {
        this.listName = listName;
    }

    public void clearCount() {
        this.passedCount = 0;
        this.testCount = 0;
    }

    public void addPassedCount() {
        passedCount++;
    }
    public void addTestCount() {
        testCount++;
    }
    public void addWordCount() {
        wordCount++;
    }
    public void subtractionWordCount() {
        if(wordCount == 0) {
            wordCount = 0;
        } else {
            wordCount--;
        }
    }

    public int getPassedCount() {
        return passedCount;
    }

    public int getTestCount() {
        return testCount;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public void setPassedCount(int passedCount) {
        this.passedCount = passedCount;
    }

    public void setTestCount(int testCount) {
        this.testCount = testCount;
    }
}
