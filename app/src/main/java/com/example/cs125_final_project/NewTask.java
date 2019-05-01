package com.example.cs125_final_project;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Random;

public class NewTask extends AppCompatActivity {

    TextView title, goalname, description, time;
    EditText goalbox, descriptionbox, timebox;
    Button savetask, cancel;

    DatabaseReference reference;
    Integer taskID = new Random().nextInt();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newtask);

        title = findViewById(R.id.title);
        goalname = findViewById(R.id.goalname);
        description = findViewById(R.id.description);
        time = findViewById(R.id.time);

        goalbox = findViewById(R.id.goalbox);
        descriptionbox = findViewById(R.id.descriptionbox);
        timebox = findViewById(R.id.timebox);

        savetask = findViewById(R.id.savetask);
        cancel = findViewById(R.id.cancel);

        savetask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Saving data to database
                reference = FirebaseDatabase.getInstance().getReference().child("MyTaskList")
                        .child("TaskID_" + taskID);
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        dataSnapshot.getRef().child("task_title").setValue(goalbox.getText().toString());
                        dataSnapshot.getRef().child("task_detail").setValue(descriptionbox.getText().toString());
                        dataSnapshot.getRef().child("task_length").setValue(timebox.getText().toString());

                        Intent backToMain = new Intent(NewTask.this, MainActivity.class);
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