package com.wons.englishwordmanager.english_setting.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.wons.englishwordmanager.R;
import com.wons.englishwordmanager.values.Word;

import java.util.ArrayList;

public class WordAdapter extends BaseAdapter {
    private ArrayList<Word> words;
    public WordAdapter() {
        this.words = new ArrayList<>();
    }
    @Override
    public int getCount() {
        return words.size();
    }

    @Override
    public Word getItem(int i) {
        return words.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context = viewGroup.getContext();
        if(view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.word_view, viewGroup, false);
        }
        TextView tv_english, tv_korean;
        tv_english = view.findViewById(R.id.tv_english);
        tv_korean = view.findViewById(R.id.tv_korean);
        tv_english.setText(words.get(i).english.trim());
        tv_korean.setText(words.get(i).korean.trim());
        return view;
    }

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

}
