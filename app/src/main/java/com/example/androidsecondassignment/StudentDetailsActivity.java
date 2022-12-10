package com.example.androidsecondassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidsecondassignment.model.Student;

import org.w3c.dom.Text;

public class StudentDetailsActivity extends AppCompatActivity {
    Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        ActionBar actionBar = getSupportActionBar();

        // showing the back button in action bar
        actionBar.setDisplayHomeAsUpEnabled(true);
        student = (Student) getIntent().getSerializableExtra("st");

        ImageView imageView = findViewById(R.id.student_details_image);
        TextView tvId = findViewById(R.id.student_details_id);
        TextView tvName = findViewById(R.id.student_details_name);
        TextView tvPhone = findViewById(R.id.student_details_phone);
        TextView tvAddress = findViewById(R.id.student_details_address);
        CheckBox cb = findViewById(R.id.student_details_cb);
        Button btn_edit = findViewById(R.id.student_details_edit_btn);

        tvId.setText("ID: " +student.getId());
        tvName.setText("Name: "+student.getName());
        tvPhone.setText("Phone: "+student.getPhone());
        tvAddress.setText("Address: "+student.getAddress());
        cb.setChecked(student.getCb());

        btn_edit.setOnClickListener(view -> {
            Intent intent = new Intent(this, StudentEditActivity.class);
            intent.putExtra("st", student);
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