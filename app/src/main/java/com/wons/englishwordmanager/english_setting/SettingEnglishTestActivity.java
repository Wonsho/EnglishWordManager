package com.wons.englishwordmanager.english_setting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

import com.wons.englishwordmanager.databinding.ActivitySettingEnglishTestBinding;
import com.wons.englishwordmanager.english_setting.adapter.SettingEnglishTestAdapter;

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
    }

    private void setView() {
        if(binding.lv.getAdapter() == null) {
            binding.lv.setAdapter(new SettingEnglishTestAdapter());
        }
        ((SettingEnglishTestAdapter)binding.lv.getAdapter()).notifyDataSetChanged();
    }




}