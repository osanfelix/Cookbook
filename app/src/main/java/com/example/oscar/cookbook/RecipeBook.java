package com.example.oscar.cookbook;

import java.util.ArrayList;
import java.util.List;

public class RecipeBook
{
    static List<Recipe> _recipes = new ArrayList<>();

    public static void loadRecipes()
    {

        _recipes.add(new Recipe("Arroz con leche",
                "http://google.com",
                new String[]{"Arroz", "Leche"}));

        _recipes.add(new Recipe("Tostada con tomate",
                "http://google.com/tomate",
                new String[]{"Pan", "Tomate"}));

    }

    public static List<Recipe> getRecipes(List<String> ingredients)
    {
        List<Recipe> out = new ArrayList<>();
        for(Recipe recipe : _recipes)
        {
            for(String ingredient : recipe.getIngredients())
            {
                if(recipe.hasIngredient(ingredient))
                    out.add(recipe);
            }
        }

        return out;
    }
}
