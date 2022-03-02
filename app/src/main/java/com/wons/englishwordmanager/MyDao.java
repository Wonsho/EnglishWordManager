package com.wons.englishwordmanager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.wons.englishwordmanager.values.Word;
import com.wons.englishwordmanager.values.WordList;

import java.util.ArrayList;

@Dao
public interface MyDao {
    @Insert
    void insertWord(Word word);
    @Insert
    void insertWordList(WordList wordList);

    @Delete
    void deleteWord(Word word);
    @Delete
    void deleteWordList(WordList wordList);

    @Update
    void upDateWord(Word word);
    @Update
    void upDateWordList(WordList wordList);

    @Query("SELECT * FROM word WHERE listName = :listName")
    Word[] getWordInList(String listName);

    @Query("SELECT * FROM WordList")
    WordList[] getWordList();

    @Query("SELECT * FROM WordList WHERE listName = :listName")
    WordList getWordList(String listName);

    @Query("SELECT * FROM (SELECT * FROM word WHERE listName = :listName) WHERE english = :english")
    Word searchWord(String listName, String english);
}
