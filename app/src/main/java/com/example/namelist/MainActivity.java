package com.example.namelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView nameEntry;
    Button addButton;
    ListView nameList;

    List<String> friends = new ArrayList<String>();

    String[] initialFriends = {"Joe", "Matt", "Jenica", "Brayden", "Jessica"};


    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEntry = findViewById(R.id.nameEntry);
        addButton = findViewById(R.id.addButton);
        nameList = findViewById(R.id.nameList);

        friends = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,friends);

        nameList.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Capture text and assign it to the variable
                String newName = nameEntry.getText().toString();

                //Clear text field after capturing data
                nameEntry.setText("");

                //Adds the name to the list
                friends.add(newName);

                Collections.sort(friends);

                //Updates the adapter on changes to the list
                adapter.notifyDataSetChanged();
            }
        });

        nameList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Name: " + friends.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }
}