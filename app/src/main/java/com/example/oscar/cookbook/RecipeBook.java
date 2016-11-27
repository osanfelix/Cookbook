package com.example.oscar.cookbook;

import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class RecipeBook
{
    static List<Recipe> _recipes = new ArrayList<>();

    public static void loadRecipes()
    {

        _recipes.add(new Recipe("Arroz con leche",
                "http://www.recetaarrozconleche.com/",
                new String[]{"Arroz", "Leche"}));

        _recipes.add(new Recipe("Tostada con tomate",
                "https://cookpad.com/es/recetas/132377-tostadas-con-tomate",
                new String[]{"Pan", "Tomate"}));

        _recipes.add(new Recipe("Pasta, tomate y atun",
                "http://www.directoalpaladar.com/recetas-de-pasta/pasta-con-atun-y-tomate",
                new String[]{"Tomate", "Pasta", "Atun"}));
    }

    public static List<Recipe> getRecipes(String[] ingredients)
    {
        List<Recipe> out = new ArrayList<>();
        for(Recipe recipe : _recipes)
        {
            if(recipe.checkIngredients(ingredients))
                out.add(recipe);
        }
        return out;
    }

    @Nullable
    public static Recipe getRecipeFromTitle(String title)
    {
        for(Recipe recipe : _recipes)
        {
            if(recipe.getTitle().equals(title))
                return recipe;
        }
        return null;
    }
}