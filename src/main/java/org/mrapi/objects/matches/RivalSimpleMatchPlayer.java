package org.mrapi.objects.matches;

import com.google.gson.annotations.SerializedName;
import org.mrapi.RivalObject;

public class RivalSimpleMatchPlayer extends RivalObject {
    @SerializedName("player_uid") public Long playerId;
    @SerializedName("hero_id") public Long heroId;
}