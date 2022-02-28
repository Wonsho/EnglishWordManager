package com.wons.englishwordmanager.english_setting;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wons.englishwordmanager.databinding.ActivitySettingEnglishTestBinding;

public class SettingEnglishTestActivity extends AppCompatActivity {

    ActivitySettingEnglishTestBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingEnglishTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}