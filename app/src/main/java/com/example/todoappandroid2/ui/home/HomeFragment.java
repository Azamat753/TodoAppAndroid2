package com.example.todoappandroid2.ui.home;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.todoappandroid2.ui.home.adapter.HomeAdapter;
import com.example.todoappandroid2.ui.home.model.TaskModel;
import com.example.todoappandroid2.ui.utils.App;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements HomeAdapter.ListenerOnRecycler {

    private com.example.todoappandroid2.databinding.FragmentHomeBinding binding;
    List<TaskModel> listTask = new ArrayList<>();
    HomeAdapter adapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = com.example.todoappandroid2.databinding.FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setAdapter();
    }

    private void setAdapter() {
        if (App.getInstance().getDataBase().taskDao().getAll()!=null){
            listTask = App.getInstance().getDataBase().taskDao().getAll();
        }
        adapter = new HomeAdapter(listTask,this);
        binding.homeRecycler.setAdapter(adapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onItemClick(TaskModel model) {
        new AlertDialog.Builder(requireContext())
                .setTitle("Delete entry")
                .setMessage("Are you sure you want to delete this entry?")
                .setPositiveButton(android.R.string.yes, (dialog, which) -> {
                    Toast.makeText(requireContext(), "delete "+model.title, Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}