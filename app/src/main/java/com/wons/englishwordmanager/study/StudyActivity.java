package com.wons.englishwordmanager.study;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.wons.englishwordmanager.R;
import com.wons.englishwordmanager.databinding.ActivityStudyBinding;

public class StudyActivity extends AppCompatActivity {

    ActivityStudyBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudyBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}