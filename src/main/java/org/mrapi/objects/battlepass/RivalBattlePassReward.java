package org.mrapi.objects.battlepass;

import com.google.gson.annotations.SerializedName;
import org.mrapi.objects.RivalItem;
import org.mrapi.RivalObject;
import org.mrapi.objects.heroes.RivalHeroSkin;

import java.lang.reflect.Type;

public class RivalBattlePassReward extends RivalObject {
    public Object item;
    public String cost;
    @SerializedName("is_free") public boolean isFree;

    public RivalItem getRewardItem() {
        if (item instanceof RivalItem) {
            return (RivalItem) item;
        }
        return new RivalItem();
    }

    public RivalHeroSkin getRewardSkin() {
        if (item instanceof RivalHeroSkin) {
            return (RivalHeroSkin) item;
        }
        return new RivalHeroSkin();
    }

    public String getRewardString() {
        if (item instanceof String) {
            return (String) item;
        }
        return "null";
    }

    public Type getItemType() {
        return item instanceof RivalItem ? RivalItem.class : item instanceof RivalHeroSkin ? RivalHeroSkin.class : String.class;
    }
}