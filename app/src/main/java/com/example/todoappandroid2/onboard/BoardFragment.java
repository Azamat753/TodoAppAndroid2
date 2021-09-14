package com.example.todoappandroid2.onboard;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todoappandroid2.MainActivity;
import com.example.todoappandroid2.R;
import com.example.todoappandroid2.databinding.FragmentBoardBinding;
import com.example.todoappandroid2.ui.utils.Constants;

import org.jetbrains.annotations.NotNull;

public class BoardFragment extends Fragment {

    private FragmentBoardBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentBoardBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        showBoarding();
    }

    @SuppressLint("ResourceAsColor")
    private void showBoarding() {
        if (getArguments() != null) {
            int position = getArguments().getInt(Constants.POSITION_FRAGMENT);
            switch (position) {
                case 0:
                    binding.titleText.setText(R.string.first_text_board);
                    binding.boardImage.setImageResource(R.drawable.boardfirst);
                    break;
                case 1:
                    binding.titleText.setText(R.string.second_text_board);
                    binding.boardImage.setImageResource(R.drawable.boardtwo);
                    break;
                case 2:
                    binding.titleText.setText(R.string.third_text_board);
                    startWork();
                    break;
            }
        }
    }

    private void startWork() {
        binding.startWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = requireActivity().getSharedPreferences(Constants.BOARD_PREFERENCE, Context.MODE_PRIVATE);
                sharedPreferences.edit().putBoolean(Constants.IS_SHOWN, true).apply();
                startActivity(new Intent(requireContext(),MainActivity.class));
            }
        });
    }
}