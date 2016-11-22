package com.example.oscar.cookbook.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.oscar.cookbook.R;

public class RecipeActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
    }

    @Override
    protected void onStart()
    {
        // Analize intent

        Intent ingredientsIntent = getIntent();

    }

    @Override
    protected  void onPause()
    {

    }

}
