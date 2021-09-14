package com.example.todoappandroid2.onboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.todoappandroid2.MainActivity;
import com.example.todoappandroid2.databinding.ActivityOnBoardBinding;
import com.example.todoappandroid2.ui.utils.Constants;

public class OnBoardActivity extends AppCompatActivity {
    private ActivityOnBoardBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOnBoardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        checkShowBoard();
        initViewPager();
    }

    private void checkShowBoard() {
        SharedPreferences sharedPreferences = getSharedPreferences(Constants.BOARD_PREFERENCE, MODE_PRIVATE);
        boolean isShown = sharedPreferences.getBoolean(Constants.IS_SHOWN, false);
        if (isShown) {
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    private void initViewPager() {
        binding.viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
    }
}