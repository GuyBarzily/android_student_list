package com.example.androidsecondassignment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;


import com.example.androidsecondassignment.model.Model;
import com.example.androidsecondassignment.model.Student;

import java.io.Serializable;
import java.util.List;
public class StudentRecyclerListActivity extends AppCompatActivity {
    List<Student> data;
    ActionBar actionBar;
    StudentRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_recycler_list);

        actionBar = getSupportActionBar();
        actionBar.setTitle("Students List");

        data = Model.instance().getAllStudents();
        RecyclerView list = findViewById(R.id.student_recycler_list);
        list.setHasFixedSize(true);

        list.setLayoutManager(new LinearLayoutManager(this));
        adapter = new StudentRecyclerAdapter();
        list.setAdapter(adapter);

        Button add_btn = findViewById(R.id.student_recycler_addbtn);
        add_btn.setOnClickListener(view -> {
            Intent intent = new Intent(this,StudentAddActivity.class);
//            intent.putExtra("adapter",  adapter);
            startActivity(intent);
        });

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Student st = data.get(pos);
                Intent intent = new Intent(StudentRecyclerListActivity.this,StudentDetailsActivity.class);
                intent.putExtra("st",st);

                startActivity(intent);
                Log.d("TAG", "Row was clicked " + String.valueOf(st.getId()));
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();

//        data = Model.instance().getAllStudents();
//        RecyclerView list = findViewById(R.id.student_recycler_list);
//        list.setHasFixedSize(true);
//
//        list.setLayoutManager(new LinearLayoutManager(this));
//        StudentRecyclerAdapter adapter = new StudentRecyclerAdapter();
//        list.setAdapter(adapter);
    }


    class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView nameTv;
        TextView idTv;
        CheckBox cb;
        public StudentViewHolder(@NonNull View itemView,OnItemClickListener listener) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.studentlistrow_name_tv);
            idTv = itemView.findViewById(R.id.studentlistrow_id_tv);
            cb = itemView.findViewById(R.id.studentlistrow_cb);
            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = (int)cb.getTag();
                    Student st = data.get(pos);
                    st.setCb( cb.isChecked());

                }
            });
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    listener.onItemClick(pos);
                }
            });
        }

        public void bind(Student st, int pos) {
            nameTv.setText(st.getName());
            idTv.setText(st.getId());
            cb.setChecked(st.getCb());
            cb.setTag(pos);
        }
    }

    public interface OnItemClickListener{
        void onItemClick(int pos);
    }
    class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder>  {
        OnItemClickListener listener;
        void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }
        @NonNull
        @Override
        public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = getLayoutInflater().inflate(R.layout.student_listrow,parent,false);
            return new StudentViewHolder(view,listener);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
            Student st = data.get(position);
            holder.bind(st,position);
        }

        @Override
        public int getItemCount() {
            return data.size();
        }
    }

}