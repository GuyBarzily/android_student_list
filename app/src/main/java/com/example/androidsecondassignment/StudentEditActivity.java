package com.example.androidsecondassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.androidsecondassignment.model.Model;
import com.example.androidsecondassignment.model.Student;

public class StudentEditActivity extends AppCompatActivity {

    Student student;
    ActionBar actionBar;
    TextView name,id,phone,address;
    CheckBox cb;
    Button btn_save,btn_delete, btn_cancel;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_edit);

        pos = getIntent().getIntExtra("pos",-1);
        student = Model.instance().getAllStudents().get(pos);

        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Edit Student");

        name = findViewById(R.id.student_edit_name);
        id = findViewById(R.id.student_edit_id);
        phone = findViewById(R.id.student_edit_phone);
        address = findViewById(R.id.student_edit_address);
        cb = findViewById(R.id.student_edit_checked);

        btn_save = findViewById(R.id.student_edit_save);
        btn_cancel = findViewById(R.id.student_edit_cancel);
        btn_delete = findViewById(R.id.student_edit_delete);


        btn_save.setOnClickListener(view -> {
            student.setName(name.getText().toString());
            student.setCb(cb.isChecked());
            student.setId(id.getText().toString());
            student.setAddress(address.getText().toString());
            student.setPhone(phone.getText().toString());
            Intent intent = new Intent(this,StudentRecyclerListActivity.class);
            startActivity(intent);
        });

        btn_cancel.setOnClickListener(view -> this.finish());

        btn_delete.setOnClickListener(view -> {
            Model.instance().getAllStudents().remove(pos);
            Intent intent = new Intent(this,StudentRecyclerListActivity.class);
            startActivity(intent);


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