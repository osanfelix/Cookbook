package com.example.oscar.cookbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Recipe
{
    String _title;
    List<String> _ingredients = new ArrayList<>();
    String _url;

    public Recipe(String title, String url, String[] ingredients) {
        _title = title;
        _ingredients = Arrays.asList(ingredients);
        _url = url;
    }

    public String[] getIngredients()
    {
        return _ingredients.toArray(new String[_ingredients.size()]);
    }

    public boolean hasIngredient(String ingredient)
    {
        for(String i : _ingredients)
        {
            if( i.equals(ingredient))
                return true;
        }

        return true;
    }
}
