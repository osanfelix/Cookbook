package com.example.oscar.cookbook.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.oscar.cookbook.Activities.RecipeActivity;
import com.example.oscar.cookbook.R;
import com.example.oscar.cookbook.Recipe;

/**
 * Created by Oscar on 24/11/2016.
 */

public class RecipeAdapter extends ArrayAdapter<Recipe>
{
    public RecipeAdapter(Context context, Recipe[] objects)
    {
        super(context,0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        // Get the recipe item for this position
        Recipe recipe = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_recipe_item, parent, false);
        }

        // Lookup view for data population
        TextView titleText = (TextView) convertView.findViewById(R.id.recipe_title);
        TextView ingredientsText = (TextView) convertView.findViewById(R.id.recipe_ingredients);

        // Populate the title and ingredients into the template view using the data object
        titleText.setText(recipe.getTitle());
        ingredientsText.setText("");
        for(String ingredient : recipe.getIngredients())
        {
            ingredientsText.append(ingredient + ", ");
        }
        ingredientsText.setText(ingredientsText.getText().subSequence(0, ingredientsText.getText().length() - 2));

        // Attach 'clickListener'


        // Return the completed view to render on screen
        return convertView;

    }
}
