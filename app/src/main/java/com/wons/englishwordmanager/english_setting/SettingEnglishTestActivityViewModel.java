package com.wons.englishwordmanager.english_setting;

import android.content.Context;

import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.wons.englishwordmanager.MainDataBase;
import com.wons.englishwordmanager.MyDao;
import com.wons.englishwordmanager.values.Word;
import com.wons.englishwordmanager.values.WordList;

import java.util.ArrayList;
import java.util.Arrays;

public class SettingEnglishTestActivityViewModel extends ViewModel {
    private static MainDataBase dataBase;
    private static MyDao dao;

    public void setDataBaseBuild(Context context) {
        if (dataBase == null) {
            dataBase = Room.databaseBuilder(context, MainDataBase.class, "databaseInSettingEnglish").allowMainThreadQueries().build();
            dao = dataBase.getDao();
        }
    }

    public ArrayList<WordList> getWordListData() {
        return new ArrayList<>(Arrays.asList(dao.getWordList()));
    }

    public void insertWordList(WordList wordList) {
        dao.insertWordList(wordList);
    }

    public void deleteWordList(WordList wordList) {
        dao.deleteWordList(wordList);
        ArrayList<Word> arr = getWordInList(wordList.listName);
        if(arr == null) return;
        for (Word word : arr) {
            deleteWord(word);
        }
    }

    public void updateWordList(WordList wordList) {
        dao.upDateWordList(wordList);
        ArrayList<Word> arr = getWordInList(wordList.listName);
        if(arr == null) return;
        for (Word word : arr) {
            word.listName = wordList.listName;
            updateWord(word);
        }
    }

    private void updateWord(Word word) {
        dao.upDateWord(word);
    }

    private void deleteWord(Word word) {
        dao.deleteWord(word);
    }

    private ArrayList<Word> getWordInList(String title) {
        return new ArrayList<>(Arrays.asList(dao.getWordInList(title)));
    }

    public WordList getWordList(String title) {
        return dao.getWordList(title);
    }
}
