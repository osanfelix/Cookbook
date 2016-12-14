package com.example.oscar.cookbook.Activities;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.oscar.cookbook.Adapters.*;
import com.example.oscar.cookbook.*;

import java.util.Arrays;
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
            ingredients = savedInstanceState.getStringArray("Ingredients");
        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();

        list.setAdapter(null);
        list.invalidateViews();

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

        //      Feed the ListView:
        // Create the adapter
        RecipeAdapter adapterRecipes = new RecipeAdapter(this, recipes.toArray(new Recipe[recipes.size()]));

        // Set the adapter
        list.setAdapter(adapterRecipes);

        // ListView Item Click Listener
        list.setOnItemClickListener(new AdapterView.OnItemClickListener()
                    {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view,
                                                int position, long id)
                        {
                            // ListView Clicked item value
                            Recipe  recipe = (Recipe) list.getItemAtPosition(position);

                            // Show Alert
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(recipe.getUrl()));
                            startActivity(browserIntent);
                        }
                    });
    }

    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);

        outState.putInt("Number", number);
        for(int i = 0; i < number; i++)
        {
            outState.putStringArray("Ingredients", ingredients);
        }
    }
}