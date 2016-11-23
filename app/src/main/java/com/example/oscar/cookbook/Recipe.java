package com.example.oscar.cookbook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Recipe
{
    private String _title;
    private List<String> _ingredients = new ArrayList<>();
    private String _url;

    public Recipe(String title, String url, String[] ingredients) {
        _title = title;
        _ingredients = Arrays.asList(ingredients);
        _url = url;
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

    // If all the _ingredients are in ingredients => returns 'true'
    public boolean checkIngredients(String[] ingredients)
    {
        List<String> ingredientsList = Arrays.asList(ingredients);

        for(String myIngredient : _ingredients)
        {
            if(!ingredientsList.contains(myIngredient))
                return false;
        }
        return true;
    }

    public String getTitle() {
        return _title;
    }

    public String[] getIngredients()
    {
        return _ingredients.toArray(new String[_ingredients.size()]);
    }

    public String getUrl()
    {
        return _url;
    }
}
