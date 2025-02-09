package com.example.todoapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AddTaskActivity extends AppCompatActivity {

    EditText edtTask;
    Button btnSave;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_task);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        edtTask = findViewById(R.id.edtTask);
        btnSave = findViewById(R.id.btnSave);
        dbHelper = new DBHelper(this);

        btnSave.setOnClickListener(v -> {
            String taskText = edtTask.getText().toString();
            if (!taskText.isEmpty()) {
                dbHelper.insertTask(taskText);
                Toast.makeText(AddTaskActivity.this, "Task Added", Toast.LENGTH_SHORT).show();
                setResult(RESULT_OK);
                finish();
            } else {
                Toast.makeText(AddTaskActivity.this, "Enter a task!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}