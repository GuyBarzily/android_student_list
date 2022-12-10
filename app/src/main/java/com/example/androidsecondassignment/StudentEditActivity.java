package com.example.androidsecondassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidsecondassignment.model.Student;

public class StudentEditActivity extends AppCompatActivity {

    Student student;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_edit);

        student = (Student) getIntent().getSerializableExtra("st");

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Edit Student");


        Button btn_sub = findViewById(R.id.student_edit_submit);
        btn_sub.setOnClickListener(view -> {
            EditText et_name = findViewById(R.id.student_edit_name);
            student.setName(et_name.getText().toString());
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}