package com.example.oscar.cookbook;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

// Wrapper de SharedPreferences
public class RecetesDB
{
    // Internamente RecetesDB trabaja con SharedPReferences para obtener todas las recetas
    // en una lista con la siguiente estructura:
    // NUMBER                       <==> (int)    Total de recetas (0, 1, 2, ...)
    // RECETA_0                     <==> (String) Titulo receta      (master key)
    // RECETA_0_URL                 <==> (String) url receta
    // RECETA_0_NUMBER              <==> (int)    Total de ingredientes en la receta 1
    // RECETA_0_INGREDIENTE_0       <==> (String) Ingr. 1 de la receta 1
    // RECETA_0_INGREDIENTE_1       <==> (String) Ingr. 2 de la receta 1
    // ...


    // Attributes: Constants
    protected static final String dbKey         = "RECETA";
    protected static final String dburl         = "URL";
    protected static final String dbsubKey      = "INGREDIENTE";
    protected static final String dbNumber      = "NUMBER";
    protected static final String dbSeparator   = "_";

    // Attributes: variables
    protected List<Recipe> _recipes = null;

    // Attributes: SharedPreferences
    protected SharedPreferences _sp;


    // ______ Singleton instance _______
    protected static RecetesDB _instance = null;

    public static RecetesDB getInstance()
    {
        if(_instance == null)
            _instance = new RecetesDB();
        return _instance;
    }
    // ______ __________________ _______

    // Public mandatory methods
    public void setPrefences(SharedPreferences sp)
    {
        _sp = sp;
    }

    public void loadRecipes()
    {
        if(_sp == null)
            System.err.print("Error, Shared Preferences no asignado!!");

        _recipes  = new ArrayList<>();

        // Get all the recipes from DB
        int totalRecipes = _sp.getInt(dbNumber ,0);

        // Foreach recipe
        for(int i = 0; i < totalRecipes; i++)
        {
            List<String> ingredients = new ArrayList<>();
            String title    = _sp.getString(dbKey + dbSeparator + i, null);
            String url      = _sp.getString(dbKey + dbSeparator + i + dbSeparator + dburl, null);

            int totalIngredients = _sp.getInt(dbKey + dbSeparator + i + dbSeparator + dbNumber ,0);
            // Foreach ingredient
            for(int j = 0; j < totalIngredients; j++)
            {
                // Get ingredients
                ingredients.add(_sp.getString(dbKey + dbSeparator + i + dbSeparator + dbsubKey + dbSeparator + j,null));
            }

            // Create and add recipe from DB
            _recipes.add(new Recipe(title, url, ingredients.toArray(new String[ingredients.size()])));
        }
    }

    // Public methods
    public List<Recipe> getRecipes()
    {
        return _recipes;
    }

    // Public methods
    public void saveRecipe(Recipe recipe)
    {
        int number = _recipes.size();
        SharedPreferences.Editor editor = _sp.edit();
        // Title
        editor.putString(dbKey + dbSeparator + number,recipe.getTitle());
        // URL
        editor.putString(dbKey + dbSeparator + number + dbSeparator + dburl,recipe.getUrl());
        // Number ingredients
        editor.putInt(dbKey + dbSeparator + number + dbSeparator+ dbNumber,recipe.getIngredients().length);
        for(int i= 0; i < recipe.getIngredients().length; i++)
        {
            editor.putString(dbKey + dbSeparator + number + dbSeparator + dbsubKey + dbSeparator  + i,recipe.getIngredients()[i]);
        }
        //Last: Increase recipes number
        editor.putInt(dbNumber,_recipes.size() + 1);

        //editor.commit();
        editor.commit();

        _recipes.add(recipe);
    }
}
