package com.hidocmatn.timelessjs.recipe;

import com.google.gson.JsonArray;
import dev.latvian.kubejs.item.ingredient.IngredientJS;
import dev.latvian.kubejs.recipe.RecipeJS;
import dev.latvian.kubejs.util.ListJS;

public class TimelessRecipeJS extends RecipeJS {
    public final String inputName;
    public final String outputName;

    public TimelessRecipeJS(String input, String output) {
        this.inputName = input;
        this.outputName = output;
    }

    public TimelessRecipeJS() {
        this("materials","result");
    }

    @Override
    public void create(ListJS args) {
        outputItems.add(parseResultItem(args.get(1)));
        inputItems.addAll(parseIngredientItemStackList(args.get(0)));
    }

    @Override
    public void deserialize() {
        outputItems.add(parseResultItem(json.get(outputName)));
        inputItems.addAll(parseIngredientItemStackList(json.get(inputName)));
    }

    @Override
    public void serialize() {
        if (serializeOutputs) {
            JsonArray inputArray = new JsonArray();
            for (IngredientJS ingredient: inputItems) {
                inputArray.add(ingredient.toJson());
            }
            json.add(inputName, inputArray);
        }
        if (serializeInputs) {
            json.add(outputName, outputItems.get(0).toResultJson());
        }
    }
}
