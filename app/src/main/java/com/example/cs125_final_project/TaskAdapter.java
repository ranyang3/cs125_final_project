package com.example.cs125_final_project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<MyTaskItem> myTasks;


    TaskAdapter(Context setContext, ArrayList<MyTaskItem> setMyTasks) {
        context = setContext;
        myTasks = setMyTasks;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.items, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, int position) {

        myViewHolder.taskTitle.setText(myTasks.get(position).getTask_title());
        myViewHolder.taskDetail.setText(myTasks.get(position).getTask_detail());
        myViewHolder.taskLength.setText(myTasks.get(position).getTask_length());
        myViewHolder.taskState.setText(myTasks.get(position).getTask_state());

        final String getTaskTitle = myTasks.get(position).getTask_title();
        final String getTaskDetail = myTasks.get(position).getTask_detail();
        final String getTaskLength = myTasks.get(position).getTask_length();
        final String getTaskState = myTasks.get(position).getTask_state();
        final String getTaskKey = myTasks.get(position).getTask_key();


        myViewHolder.taskTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox)v).isChecked()) {
                    myViewHolder.taskState.setText("DONE!");
                } else {
                    myViewHolder.taskState.setText("IN PROGRESS");
                }
            }
        });



        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aa = new Intent(context, EditTask.class);
                aa.putExtra("task_title", getTaskTitle);
                aa.putExtra("task_detail", getTaskDetail);
                aa.putExtra("task_length", getTaskLength);
                aa.putExtra("task_state", getTaskState);
                aa.putExtra("task_key", getTaskKey);
                context.startActivity(aa);
            }
        });

    }

    @Override
    public int getItemCount() {
        return myTasks.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        CheckBox taskTitle;
        TextView taskDetail, taskLength, taskState;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            taskTitle = itemView.findViewById(R.id.task_title);
            taskDetail = itemView.findViewById(R.id.task_detail);
            taskLength = itemView.findViewById(R.id.task_length);
            taskState = itemView.findViewById(R.id.task_state);
        }
    }
}
