package com.example.cs125_final_project;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView today, goodjob;
    Button add;
    ListView todos;

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
