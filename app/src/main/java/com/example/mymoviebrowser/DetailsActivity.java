package com.example.mymoviebrowser;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailsactivity);

        Movie movie = (Movie) getIntent().getSerializableExtra("movie");
        FragmentTransaction fts = getSupportFragmentManager().beginTransaction();
        DetailsFragment df = DetailsFragment.newInstance(movie);
        fts.add(R.id.framelayout,df);
        fts.commit();
    }
}