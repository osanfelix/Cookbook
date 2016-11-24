package com.example.oscar.cookbook.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.oscar.cookbook.R;
import com.example.oscar.cookbook.Recipe;
import com.example.oscar.cookbook.RecipeBook;

import java.util.List;

public class RecipeActivity extends AppCompatActivity
{
    int number = 0;
    String[] ingredients = null;
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        // Get the list
        list = (ListView) findViewById(R.id.recipe_list);

        // Get bundle and fill data (same intent data)
        if(savedInstanceState != null)
        {
            number = savedInstanceState.getInt("Number",0);
            ingredients = new String[number];

            for(int i = 0; i < number; i++)
                ingredients[i] = savedInstanceState.getString("Ingredient_" + i);
        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        //loadRecipes
        RecipeBook.loadRecipes();


        // Analize intent
        Intent ingredientsIntent = getIntent();

        if(ingredientsIntent != null)   // load Data
        {
            number = ingredientsIntent.getIntExtra("Number", 0);
            ingredients = new String[number];

            for(int i = 0; i < number; i++)
                ingredients[i] = ingredientsIntent.getStringExtra("Ingredient_" + i);
        }

        // Get recipes
        List<Recipe> recipes = RecipeBook.getRecipes(ingredients);

        // Create the adapter
        ArrayAdapter<String> adapterRecipes = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, new String[]{"Caca", "futi"});

        // Set the adapter
        list.setAdapter(adapterRecipes);


        /*
        for(Recipe recipe : recipes)
        {
            //TODO: Fill screen
        }
        */
    }

    @Override
    protected  void onPause()
    {
        // TODO: Save bundle
    }
}
