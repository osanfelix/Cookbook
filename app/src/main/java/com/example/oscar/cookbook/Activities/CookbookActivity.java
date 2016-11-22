package com.example.oscar.cookbook.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.oscar.cookbook.R;

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
    CheckBox oilCheckbox;

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
        oilCheckbox = (CheckBox)findViewById(R.id.Oil);
    }

    public void onClick(View view)
    {
        List<String> ingredients = new ArrayList<>();
        if(tomatoCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Tomato));
        if(potatoCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Potato));








        // TODO create Intent passing arguments

        Intent intent = new Intent(this, RecipeActivity.class);

        intent.putExtra("Number", ingredients.size());
        intent.putExtra("Ingredient_1", ingredients.get(0));
        intent.putExtra("Ingredient_2", ingredients.get(1));
        //...

        ingredients.add("patata");

        startActivity(intent);






    }
}
