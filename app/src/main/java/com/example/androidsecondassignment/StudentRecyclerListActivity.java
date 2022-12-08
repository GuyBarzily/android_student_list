package com.example.androidsecondassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.androidsecondassignment.model.Model;
import com.example.androidsecondassignment.model.Student;

import java.util.List;

public class StudentRecyclerListActivity extends AppCompatActivity {
    List<Student> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_recycler_list);

        data = Model.instance().getAllStudents();
        RecyclerView list = findViewById(R.id.student_recycler_list);
        list.setHasFixedSize(true);

        list.setLayoutManager(new LinearLayoutManager(this));
        //StudentRecyclerAdapter adapter = new StudentRecyclerAdapter();




    }
}