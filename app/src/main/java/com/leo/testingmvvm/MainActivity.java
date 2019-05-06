package com.leo.testingmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.leo.testingmvvm.adapter.RecyclerAdapter;
import com.leo.testingmvvm.models.NicePlace;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private FloatingActionButton mFab;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler_view_id);
        progressBar = findViewById(R.id.progress_bar);

        //initial recyclerview with recycler adapter
        initRecyclerView();


    }

    private void initRecyclerView() {
        adapter = new RecyclerAdapter(new ArrayList<NicePlace>(),MainActivity.this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }





}
