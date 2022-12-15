package com.example.androidsecondassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.androidsecondassignment.model.Model;
import com.example.androidsecondassignment.model.Student;


public class StudentAddActivity extends AppCompatActivity {
    EditText id,name,address,phone;
    Button cancel_btn,save_btn;
    ActionBar actionBar;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_add);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Add Student");

        id =  findViewById(R.id.student_add_id);
        name =  findViewById(R.id.student_add_name);
        address =  findViewById(R.id.student_add_address);
        phone =  findViewById(R.id.student_add_phone);
        imageView = findViewById(R.id.student_add_image);

        imageView.setOnClickListener(view -> {
//            imageView.setImageResource(R.drawable.avatar2);
        });


        cancel_btn =  findViewById(R.id.student_add_cancelBtn);
        save_btn = findViewById(R.id.student_add_saveBtn);

        save_btn.setOnClickListener(view -> {
            Student st = new Student(name.getText().toString(),id.getText().toString(),"",
                    false,address.getText().toString(),phone.getText().toString());

            Model.instance().addStudent(st);
            this.finish();

        });

        cancel_btn.setOnClickListener(view -> this.finish());

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