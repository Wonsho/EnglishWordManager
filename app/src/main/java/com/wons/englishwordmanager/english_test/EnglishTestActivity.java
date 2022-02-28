package com.wons.englishwordmanager.english_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Room;

import android.os.Bundle;

import com.wons.englishwordmanager.databinding.ActivityEnglishTestBinding;

public class EnglishTestActivity extends AppCompatActivity {
    ActivityEnglishTestBinding binding;
    EnglishTestViewModel englishTestViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEnglishTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        englishTestViewModel = new ViewModelProvider(this).get(EnglishTestViewModel.class);

    }
}