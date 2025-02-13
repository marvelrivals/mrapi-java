package org.mrapi.objects.battlepass;

import com.google.gson.*;
import org.mrapi.objects.RivalItem;
import org.mrapi.objects.heroes.RivalHeroSkin;

import java.lang.reflect.Type;

public class RivalBattlePassRewardDeserializer implements JsonDeserializer<RivalBattlePassReward> {
    @Override
    public RivalBattlePassReward deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();
        JsonElement itemElement = jsonObject.get("item");
        Object item;
        if (itemElement.isJsonPrimitive() && itemElement.getAsJsonPrimitive().isString()) {
            item = itemElement.getAsString();
        } else if (itemElement.isJsonObject()) {
            JsonObject itemObject = itemElement.getAsJsonObject();
            if (itemObject.has("hero_id")) {
                item = context.deserialize(itemObject, RivalHeroSkin.class);
            } else if (itemObject.has("applicable_hero")) {
                item = context.deserialize(itemObject, RivalItem.class);
            } else {
                throw new JsonParseException("Unknown item type: " + itemObject);
            }
        } else {
            throw new JsonParseException("Unexpected item format: " + itemElement);
        }

        String cost = jsonObject.get("cost").getAsString();
        boolean isFree = jsonObject.get("is_free").getAsBoolean();

        var reward = new RivalBattlePassReward();
        reward.cost = cost;
        reward.isFree = isFree;
        reward.item = item;
        return reward;
    }
}
