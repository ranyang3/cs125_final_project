package com.example.cs125_final_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class EditTask extends AppCompatActivity {

    EditText taskTitle, taskDetail, taskLength;
    Button btnDelete, btnSaveUpdate;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        taskTitle = findViewById(R.id.goalbox);
        taskDetail = findViewById(R.id.descriptionbox);
        taskLength = findViewById(R.id.timebox);

        btnDelete = findViewById(R.id.btnDelete);
        btnSaveUpdate = findViewById(R.id.btnSaveUpdate);

        //get a value from previous page
        taskTitle.setText(getIntent().getStringExtra("task_title"));
        taskDetail.setText(getIntent().getStringExtra("task_detail"));
        taskLength.setText(getIntent().getStringExtra("task_length"));

        final String taskKey = getIntent().getStringExtra("task_key");
        final String taskState = getIntent().getStringExtra("task_state");

        reference = FirebaseDatabase.getInstance().getReference().child("MyTaskList")
                .child("TaskID_" + taskKey);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Intent backToMain = new Intent(EditTask.this, MainActivity.class);
                            startActivity(backToMain);
                        } else {
                            Toast.makeText(getApplicationContext(), "Failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

        //make an event for btnSaveUpdate
        btnSaveUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        dataSnapshot.getRef().child("task_title").setValue(taskTitle.getText().toString());
                        dataSnapshot.getRef().child("task_detail").setValue(taskDetail.getText().toString());
                        dataSnapshot.getRef().child("task_length").setValue(taskLength.getText().toString());
                        dataSnapshot.getRef().child("task_state").setValue(taskState);
                        dataSnapshot.getRef().child("task_key").setValue(taskKey);

                        Intent backToMain = new Intent(EditTask.this, MainActivity.class);
                        startActivity(backToMain);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                    }
                });
            }
        });
    }
}
