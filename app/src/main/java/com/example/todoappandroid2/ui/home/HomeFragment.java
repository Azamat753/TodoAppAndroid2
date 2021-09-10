package com.example.todoappandroid2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.todoappandroid2.R;
import com.example.todoappandroid2.ui.home.adapter.HomeAdapter;
import com.example.todoappandroid2.ui.home.model.TaskModel;
import com.example.todoappandroid2.ui.utils.Constants;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private com.example.todoappandroid2.databinding.FragmentHomeBinding binding;
    TaskModel taskModel;
    ArrayList<TaskModel> listTask = new ArrayList<>();
    HomeAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = com.example.todoappandroid2.databinding.FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addTask();
        if (getArguments() == null) {
            taskModel = (TaskModel) getArguments().getSerializable(Constants.KEY_TASK_MODEL);
        }
        listTask.add(taskModel);
    }

    private void addTask() {
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}