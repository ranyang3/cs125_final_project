package com.example.cs125_final_project;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NewTask extends Activity {

    TextView title, goalname, description, time;
    EditText goalbox, descriptionbox, timebox;
    Button savetask, cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newtask);

        title = findViewById(R.id.title);
        goalname = findViewById(R.id.goalname);
        goalbox = findViewById(R.id.goalbox);
        description = findViewById(R.id.description);
        time = findViewById(R.id.time);
        descriptionbox = findViewById(R.id.descriptionbox);
        timebox = findViewById(R.id.timebox);
        savetask = findViewById(R.id.savetask);
        cancel = findViewById(R.id.cancel);
    }
}