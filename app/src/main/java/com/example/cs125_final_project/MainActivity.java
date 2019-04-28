package com.example.cs125_final_project;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView today, goodjob;
    Button add;
    RecyclerView todos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        today = findViewById(R.id.today);
        goodjob = findViewById(R.id.goodjob);
        add = findViewById(R.id.add);
        todos = findViewById(R.id.todos);
    }
}
