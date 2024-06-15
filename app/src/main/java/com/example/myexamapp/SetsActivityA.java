package com.example.myexamapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.example.myexamapp.Adapters.GrideAdapterA;
import com.example.myexamapp.databinding.ActivityMainBinding;
import com.example.myexamapp.databinding.ActivitySetsActivityBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class SetsActivityA extends AppCompatActivity {

    ActivitySetsActivityBinding binding;
    FirebaseDatabase database;
    GrideAdapterA adapter;

    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySetsActivityBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // getSupportActionBar().hide();
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        database = FirebaseDatabase.getInstance();
        key = getIntent().getStringExtra("key");

        adapter = new GrideAdapterA(getIntent().getIntExtra("sets",0),
                getIntent().getStringExtra("category"));

        binding.gridView.setAdapter(adapter);



    }
}