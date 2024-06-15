package com.example.myexamapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myexamapp.databinding.ActivityDumbBinding;

public class DumbActivity extends AppCompatActivity {

    ActivityDumbBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityDumbBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnstdnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent= new Intent(DumbActivity.this,MainActivity.class);
                startActivity(intent);


            }
        });

        binding.btntechr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DumbActivity.this,TeacherMainActivity.class);
                startActivity(intent);
            }
        });

    }
}