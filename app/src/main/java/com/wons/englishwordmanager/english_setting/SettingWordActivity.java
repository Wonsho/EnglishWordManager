package com.wons.englishwordmanager.english_setting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.wons.englishwordmanager.databinding.ActivitySettingWordBinding;
import com.wons.englishwordmanager.english_setting.adapter.WordAdapter;
import com.wons.englishwordmanager.english_setting.dialog.SettingCallBackForWord;
import com.wons.englishwordmanager.english_setting.dialog.SettingDialogCallBack;
import com.wons.englishwordmanager.english_setting.dialog.SettingDialogs;
import com.wons.englishwordmanager.english_setting.dialog.SettingEnum;
import com.wons.englishwordmanager.english_setting.dialog.WordEnum;
import com.wons.englishwordmanager.values.Word;

import java.util.ArrayList;
import java.util.HashMap;

public class SettingWordActivity extends AppCompatActivity {
    ActivitySettingWordBinding binding;
    SettingWordActivityViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingWordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(SettingWordActivityViewModel.class);
        Intent intent = getIntent();
        String listTitle = intent.getStringExtra("title");
        binding.tvTitle.setText("리스트 이름 : " + listTitle);
        setView();
        onC();
        getWordData();
    }

    private void onC() {
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog alertDialog = new SettingDialogs().getAlertDialogForAddWord(SettingWordActivity.this, new SettingCallBackForWord() {
                    @Override
                    public void callback(HashMap<WordEnum, String> word) {
                        int code = viewModel.addWord(word.get(WordEnum.ENGLISH), word.get(WordEnum.KOREAN), getIntent().getStringExtra("title"));
                        if(code == -1) {
                            Toast.makeText(getApplicationContext(), "중복되는 항목이 있습니다", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        getWordData();
                    }
                });
                alertDialog.show();
            }
        });
        binding.lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

                AlertDialog alertDialog = new SettingDialogs().getDialogForDelete(SettingWordActivity.this, new SettingDialogCallBack() {
                    @Override
                    public void callback_code(SettingEnum code) {
                        if(code == SettingEnum.DELETE) {
                            viewModel.deleteWord(((WordAdapter)binding.lv.getAdapter()).getItem(i), getIntent().getStringExtra("title"));
                            getWordData();
                        }
                    }
                });
                alertDialog.show();
                return true;
            }
        });
    }

    private void getWordData() {
        ArrayList<Word> arr = viewModel.getWordInList(getIntent().getStringExtra("title"));
        if(arr == null) return;
        ((WordAdapter)binding.lv.getAdapter()).setWords(arr);
        setView();
    }

    private void setView() {
        if(binding.lv.getAdapter() == null) {
            binding.lv.setAdapter(new WordAdapter());
        }
        ((WordAdapter)binding.lv.getAdapter()).notifyDataSetChanged();
    }
}