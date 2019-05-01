package com.example.cs125_final_project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    Context context;
    ArrayList<MyTaskItem> myTasks;

    public TaskAdapter(Context setContext, ArrayList<MyTaskItem> setMyTasks) {
        context = setContext;
        myTasks = setMyTasks;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int position) {

        myViewHolder.taskTitle.setText(myTasks.get(position).getTask_title());
        myViewHolder.taskDetail.setText(myTasks.get(position).getTask_detail());
        myViewHolder.taskLength.setText(myTasks.get(position).getTask_length());

    }

    @Override
    public int getItemCount() {
        return myTasks.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        CheckBox taskTitle;
        TextView taskDetail, taskLength;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            taskTitle = (CheckBox) itemView.findViewById(R.id.task_title);
            taskDetail = (TextView) itemView.findViewById(R.id.task_detail);
            taskLength = (TextView) itemView.findViewById(R.id.task_length);
        }
    }
}
