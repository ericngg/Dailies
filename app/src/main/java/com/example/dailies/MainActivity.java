package com.example.dailies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements characterAdapter.onCharacterListener {

    private List<Character> characterList;

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rvMain);
        characterList = new ArrayList<>();

        setAppList();
    }

    // Sets the adapter for RecyclerView
    private void setAdapter() {
        recyclerView.setAdapter(new characterAdapter(characterList, this, this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setAppList() {
        characterList.add(new Character("Kanna"));
        characterList.add(new Character("Pathfinder"));
        characterList.add(new Character("Ark"));

        setAdapter();
    }

    @Override
    public void onCharacterClick(int position) {
        String name = characterList.get(position).getCharacter();
        Intent intent = new Intent(this, test.class);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}