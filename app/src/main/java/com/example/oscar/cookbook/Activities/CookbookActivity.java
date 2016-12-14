package com.example.oscar.cookbook.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.oscar.cookbook.R;
import com.example.oscar.cookbook.RecetesDB;
import com.example.oscar.cookbook.RecipeBook;

import java.util.ArrayList;
import java.util.List;

public class CookbookActivity extends AppCompatActivity
{
    CheckBox tomatoCheckbox;
    CheckBox potatoCheckbox;
    CheckBox riceCheckbox;
    CheckBox onionCheckbox;
    CheckBox milkCheckbox;
    CheckBox beanCheckbox;
    CheckBox eggCheckbox;
    CheckBox tuneCheckbox;
    CheckBox pasteCheckbox;
    CheckBox breadCheckbox;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cookbook);

        // Get checkbox references
        tomatoCheckbox = (CheckBox)findViewById(R.id.Tomato);
        potatoCheckbox = (CheckBox)findViewById(R.id.Potato);
        riceCheckbox = (CheckBox)findViewById(R.id.Rice);
        onionCheckbox = (CheckBox)findViewById(R.id.Onion);
        milkCheckbox = (CheckBox)findViewById(R.id.Milk);
        beanCheckbox = (CheckBox)findViewById(R.id.Bean);
        eggCheckbox = (CheckBox)findViewById(R.id.Egg);
        tuneCheckbox = (CheckBox)findViewById(R.id.Tune);
        pasteCheckbox = (CheckBox)findViewById(R.id.Paste);
        breadCheckbox = (CheckBox)findViewById(R.id.Bread);

        // Load database
        RecipeBook.loadRecipes(this);
    }

    public void onClickCreate(View view)
    {
        // Create the Intent passing arguments
        Intent intent = new Intent(this, AddRecipeActivity.class);
        startActivity(intent);
    }


    public void onClick(View view)
    {

        List<String> ingredients = new ArrayList<>();
        if(tomatoCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Tomato));
        if(potatoCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Potato));
        if(riceCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Rice));
        if(onionCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Onion));
        if(milkCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Milk));
        if(beanCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Bean));
        if(eggCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Egg));
        if(tuneCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Tune));
        if(pasteCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Paste));
        if(breadCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Bread));

        // Create the Intent passing arguments
        Intent intent = new Intent(this, RecipeActivity.class);

        intent.putExtra("Number", ingredients.size());
        for(int i = 0; i <ingredients.size(); i++)
            intent.putExtra("Ingredient_" + i, ingredients.get(i));

        startActivity(intent);
    }
}