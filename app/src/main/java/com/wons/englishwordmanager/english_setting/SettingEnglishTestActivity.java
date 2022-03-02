package com.wons.englishwordmanager.english_setting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.wons.englishwordmanager.databinding.ActivitySettingEnglishTestBinding;
import com.wons.englishwordmanager.english_setting.adapter.SettingEnglishTestAdapter;
import com.wons.englishwordmanager.english_setting.dialog.SettingCallBackForWord;
import com.wons.englishwordmanager.english_setting.dialog.SettingCallBackString;
import com.wons.englishwordmanager.english_setting.dialog.SettingDialogCallBack;
import com.wons.englishwordmanager.english_setting.dialog.SettingDialogs;
import com.wons.englishwordmanager.english_setting.dialog.SettingEnum;
import com.wons.englishwordmanager.english_setting.dialog.WordEnum;
import com.wons.englishwordmanager.values.Word;
import com.wons.englishwordmanager.values.WordList;

import java.util.ArrayList;
import java.util.HashMap;

public class SettingEnglishTestActivity extends AppCompatActivity {

    private SettingEnglishTestActivityViewModel viewModel;
    private ActivitySettingEnglishTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingEnglishTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(SettingEnglishTestActivityViewModel.class);
        setView();
        onc();
        getListData();
    }

    private void onc() {
        binding.lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), SettingWordActivity.class);
                intent.putExtra("title", ((((SettingEnglishTestAdapter)binding.lv.getAdapter()).getTitle(i))));
                startActivity(intent);
            }
        });

        binding.lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                AlertDialog alertDialog = new SettingDialogs().getDialogForReplaceOrDelete(SettingEnglishTestActivity.this, new SettingDialogCallBack() {
                    @Override
                    public void callback_code(SettingEnum code) {
                        replaceOrDelete(code, viewModel.getWordList((((SettingEnglishTestAdapter)binding.lv.getAdapter()).getItem(i)).listName));
                    }
                });
                alertDialog.show();
                return true;
            }
        });

        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              AlertDialog alertDialog = new SettingDialogs().getDialogForAddList(SettingEnglishTestActivity.this, new SettingCallBackString() {
                  @Override
                  public void callback(String title) {
                      if(viewModel.getWordList(title) == null) {
                          viewModel.insertWordList(new WordList(title));
                          getListData();
                      } else {
                          Toast.makeText(getApplicationContext(), "중복되는 이름이 있습니다", Toast.LENGTH_SHORT).show();
                      }
                  }
              });
              alertDialog.show();
            }
        });
    }

    private void replaceOrDelete(SettingEnum code, WordList list) {
        switch (code) {
            case DELETE: {
                viewModel.deleteWordList(list);
                getListData();
                break;
            }
            case REPLACE: {
                AlertDialog alertDialog = new SettingDialogs().getReplaceListName(SettingEnglishTestActivity.this, new SettingCallBackString() {
                    @Override
                    public void callback(String title) {
                        String originTitle = list.listName;
                        list.listName = title;
                       int i =  viewModel.updateWordList(list,originTitle);
                       if(i == -1) {
                           Toast.makeText(getApplicationContext(), "중복되는 리스트가 있습니다", Toast.LENGTH_SHORT).show();
                       } else  {
                           Toast.makeText(getApplicationContext(), "수정되었습니다", Toast.LENGTH_SHORT).show();
                       }
                        getListData();
                    }
                });
                alertDialog.show();
                break;
            }
        }
    }

    private void getListData() {
        ArrayList<WordList> wordLists = viewModel.getWordListData();
        ((SettingEnglishTestAdapter)binding.lv.getAdapter()).setWordLists(wordLists);
        setView();
    }

    private void setView() {
        if(binding.lv.getAdapter() == null) {
            binding.lv.setAdapter(new SettingEnglishTestAdapter());
        }
        ((SettingEnglishTestAdapter)binding.lv.getAdapter()).notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Setting", "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Setting", "onRestart");
        getListData();

    }
}