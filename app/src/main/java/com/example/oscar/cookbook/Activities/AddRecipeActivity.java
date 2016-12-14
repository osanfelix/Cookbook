package com.example.oscar.cookbook.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.oscar.cookbook.R;
import com.example.oscar.cookbook.RecetesDB;
import com.example.oscar.cookbook.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.prefs.Preferences;

public class AddRecipeActivity extends AppCompatActivity
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

    EditText titleEditText;
    EditText urlEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

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

        titleEditText = (EditText) findViewById(R.id.textTitle);
        urlEditText = (EditText) findViewById(R.id.textURL);
    }

    public void onClick(View view) {
        List<String> ingredients = new ArrayList<>();

        if (tomatoCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Tomato));
        if (potatoCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Potato));
        if (riceCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Rice));
        if (onionCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Onion));
        if (milkCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Milk));
        if (beanCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Bean));
        if (eggCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Egg));
        if (tuneCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Tune));
        if (pasteCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Paste));
        if (breadCheckbox.isChecked())
            ingredients.add(getResources().getString(R.string.Bread));

        // Check all fields implemented
        if(titleEditText.getText().toString().length() == 0 || urlEditText.getText().toString().length() == 0 || ingredients.size() == 0)
        {
            Toast toast = Toast.makeText(this, getResources().getString(R.string.CreateError), Toast.LENGTH_SHORT);
            toast.show();
        }
        else {

            // Save the recipe inte Shared Preferences
            Recipe newRecipe = new Recipe(titleEditText.getText().toString(), urlEditText.getText().toString(), ingredients.toArray(new String[ingredients.size()]));
            RecetesDB.getInstance().saveRecipe(newRecipe);


            Toast toast = Toast.makeText(this, getResources().getString(R.string.CreateNotification), Toast.LENGTH_SHORT);
            toast.show();

            finish();
        }
    }
}
