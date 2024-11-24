package com.example.assignment5;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    CountryAdapter adapter;
    List<String> countryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        // Initialize the country list
        countryList = new ArrayList<>();
        populateCountryList();

        // Set up RecyclerView
        adapter = new CountryAdapter(countryList, countryName ->
                Toast.makeText(MainActivity.this, "Selected: " + countryName, Toast.LENGTH_SHORT).show()
        );

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    private void populateCountryList() {
        String[] countries = {"Afghanistan", "Bangladesh", "Canada", "Denmark", "Egypt", "France", "Germany",
                "Hungary", "India", "Japan", "Kenya", "Luxembourg", "Mexico", "Nepal", "Oman", "Pakistan",
                "Qatar", "Russia", "Spain", "Turkey", "United States", "Vietnam", "Zimbabwe"};

        for (String country : countries) {
            countryList.add(country);
        }
    }
}
