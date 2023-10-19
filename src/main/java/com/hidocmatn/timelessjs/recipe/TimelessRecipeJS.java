package com.hidocmatn.timelessjs.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dev.latvian.kubejs.item.ingredient.IngredientJS;
import dev.latvian.kubejs.item.ingredient.IngredientStackJS;
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
    public JsonElement serializeIngredientStack(IngredientStackJS in) {
        JsonObject json = new JsonObject();
        json.add("item", in.ingredient.toJson());
        if (in.getCount() > 1) {
            json.addProperty("count", in.getCount());
        }
        return json;
    }

    @Override
    public void create(ListJS args) {
        outputItems.add(parseResultItem(args.get(0)));
        inputItems.addAll(parseIngredientItemStackList(args.get(1)));
    }

    @Override
    public void deserialize() {
        outputItems.add(parseResultItem(json.get(outputName)));
        inputItems.addAll(parseIngredientItemStackList(json.get(inputName)));
    }

    @Override
    public void serialize() {
        if (serializeOutputs) {
            json.add(outputName, outputItems.get(0).toResultJson());
        }
        if (serializeInputs) {
            JsonArray inputArray = new JsonArray();
            for (IngredientJS ingredient: inputItems) {
                inputArray.add(ingredient.toJson());
            }
            json.add(inputName, inputArray);
        }
    }
}
