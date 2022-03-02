package com.wons.englishwordmanager.english_setting;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.wons.englishwordmanager.MainDataBase;
import com.wons.englishwordmanager.MainViewModel;
import com.wons.englishwordmanager.MyDao;
import com.wons.englishwordmanager.values.Word;
import com.wons.englishwordmanager.values.WordList;

import java.util.ArrayList;
import java.util.Arrays;

public class SettingEnglishTestActivityViewModel extends ViewModel {
    public static MyDao dao = MainViewModel.dao;
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

    public int updateWordList(WordList wordList, String origin) {
        ArrayList<Word> arr = getWordInList(origin);
        Log.e("updateWordList1", origin);
        if(dao.getWordList(wordList.listName) != null) return -1;
        dao.upDateWordList(wordList);
        if(arr == null || arr.size() == 0) return 0;
        for (Word word : arr) {
            Log.e("updateWordList", "passed");
            word.listName = wordList.listName;
            updateWord(word);
        }
        return 1;
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
