package com.wons.englishwordmanager.english_setting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wons.englishwordmanager.databinding.ActivitySettingWordBinding;

public class SettingWordActivity extends AppCompatActivity {
    ActivitySettingWordBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingWordBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}