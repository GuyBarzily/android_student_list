package com.example.androidsecondassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import com.example.androidsecondassignment.model.Model;
import com.example.androidsecondassignment.model.Student;

import java.util.List;

public class StudentAddActivity extends AppCompatActivity {
    EditText id,name,address,phone;
    Button cancel_btn,save_btn;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_add);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Add Student");

        id = (EditText) findViewById(R.id.student_add_id);
        name = (EditText) findViewById(R.id.student_add_name);
        address = (EditText) findViewById(R.id.student_add_address);
        phone = (EditText) findViewById(R.id.student_add_phone);


        cancel_btn = (Button) findViewById(R.id.student_add_cancelBtn);
        save_btn = (Button) findViewById(R.id.student_add_saveBtn);

        save_btn.setOnClickListener(view -> {
            Student st = new Student(name.getText().toString(),id.getText().toString(),"",
                    false,address.getText().toString(),phone.getText().toString());

            Model.instance().addStudent(st);
            this.finish();

        });

        cancel_btn.setOnClickListener(view -> {
            this.finish();
        });

    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}