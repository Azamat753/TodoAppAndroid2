package com.example.todoappandroid2.ui.taskmindow;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.todoappandroid2.R;
import com.example.todoappandroid2.databinding.FragmentCreateTaskBinding;
import com.example.todoappandroid2.ui.home.HomeFragmentArgs;
import com.example.todoappandroid2.ui.home.model.TaskModel;
import com.example.todoappandroid2.ui.utils.App;
import com.example.todoappandroid2.ui.utils.Constants;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class CreateTaskFragment extends Fragment {
    FragmentCreateTaskBinding binding;
    TaskModel model;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCreateTaskBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        addTask();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void addTask() {
        binding.applyBtn.setOnClickListener(view -> {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("uuuu/MM/dd");
            LocalDate localDate = LocalDate.now();
            String task = binding.taskEdit.getText().toString();
            if (!task.isEmpty()) {
                model = new TaskModel(task, dtf.format(localDate));
                App.getInstance().getDataBase().taskDao().insert(model);
            }
            Navigation.findNavController(view).navigate(R.id.action_createTaskFragment_to_nav_home);
        });
    }
}