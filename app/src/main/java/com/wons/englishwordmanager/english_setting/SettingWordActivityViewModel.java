package com.wons.englishwordmanager.english_setting;

import android.widget.Toast;

import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import com.wons.englishwordmanager.MainDataBase;
import com.wons.englishwordmanager.MainViewModel;
import com.wons.englishwordmanager.MyDao;
import com.wons.englishwordmanager.values.Word;
import com.wons.englishwordmanager.values.WordList;

import java.util.ArrayList;
import java.util.Arrays;

public class SettingWordActivityViewModel extends ViewModel {
    private MyDao myDao = MainViewModel.dao;

    public ArrayList<Word> getWordInList(String title) {
        return new ArrayList<>(Arrays.asList(myDao.getWordInList(title)));
    }

    private int wordCountInList(Word word) {
        if(myDao.searchWord(word.listName, word.english) == null) {
            return 0;
        } else {
            return 1;
        }
    }

    public int addWord(String english, String korean, String listName) {
        Word word = new Word(korean, english, listName);
        int i = wordCountInList(word);
        if(i == 1) {
            return -1;
        }
        myDao.insertWord(word);
        WordList list = myDao.getWordList(listName);
        list.addWordCount();
        myDao.upDateWordList(list);
        return 0;
    }

    public void deleteWord(Word word, String listName) {
        myDao.deleteWord(word);
        WordList list = myDao.getWordList(listName);
        list.subtractionWordCount();
        myDao.upDateWordList(list);
    }
}
