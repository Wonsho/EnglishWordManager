package com.wons.englishwordmanager.english_setting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wons.englishwordmanager.R;
import com.wons.englishwordmanager.values.WordList;

import java.util.ArrayList;
import java.util.HashMap;

public class SettingEnglishTestAdapter extends BaseAdapter {
    private ArrayList<WordList> wordLists;

    public SettingEnglishTestAdapter() {
        this.wordLists = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return wordLists.size();
    }

    @Override
    public Object getItem(int i) {
        return wordLists.get(i);
    }

    public String getTitle(int i) {
        return wordLists.get(i).listName;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.word_setting_list_view, viewGroup, false);
        }
        ((TextView)view.findViewById(R.id.tv_test_name)).setText(wordLists.get(i).listName);
        ((TextView)view.findViewById(R.id.tv_wordCount)).setText(String.valueOf(wordLists.get(i).getWordCount()));
        return view;
    }
}
