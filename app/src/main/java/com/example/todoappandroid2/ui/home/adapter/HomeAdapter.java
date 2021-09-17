package com.example.todoappandroid2.ui.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.todoappandroid2.R;
import com.example.todoappandroid2.ui.home.model.TaskModel;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import kotlinx.coroutines.scheduling.Task;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    public HomeAdapter(List<TaskModel> list,ListenerOnRecycler listener) {
        this.list = list;
        this.listener= listener;
    }

    List<TaskModel> list;
    ListenerOnRecycler listener;

    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull HomeViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class HomeViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView date;

        public HomeViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            date = itemView.findViewById(R.id.date_created);

        }

        public void onBind(TaskModel model) {
            title.setText(model.title);
            date.setText(model.createdDate);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(model);
                }
            });
        }
    }

    public interface ListenerOnRecycler {
        void onItemClick(TaskModel model);
    }
}
