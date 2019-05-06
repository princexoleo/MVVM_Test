package com.leo.testingmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.leo.testingmvvm.adapter.RecyclerAdapter;
import com.leo.testingmvvm.models.NicePlace;
import com.leo.testingmvvm.viewmodels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private FloatingActionButton mFab;
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private RecyclerAdapter adapter;
    private MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycler_view_id);
        progressBar = findViewById(R.id.progress_bar);
        //mainActivityViewModel = new ViewModelProvider.AndroidViewModelFactory(MainActivity);
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);


        mainActivityViewModel.getNicePlaces().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(List<NicePlace> nicePlaces) {
                adapter.notifyDataSetChanged();
            }
        });

        //initial recyclerview with recycler adapter
        initRecyclerView();


    }

    private void initRecyclerView() {
        adapter = new RecyclerAdapter(mainActivityViewModel.getNicePlaces().getValue(),MainActivity.this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
    }
    private void showProgressbar(){
        progressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressbar(){
        progressBar.setVisibility(View.INVISIBLE);
    }

}
