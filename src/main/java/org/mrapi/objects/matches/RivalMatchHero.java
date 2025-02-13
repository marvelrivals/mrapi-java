package org.mrapi.objects.matches;

import com.google.gson.annotations.SerializedName;
import org.mrapi.objects.RivalDuration;
import org.mrapi.RivalObject;

public class RivalMatchHero extends RivalObject {
    @SerializedName("hero_id") public Integer heroId;
    public RivalDuration playtime;
    public Integer kills;
    public Integer deaths;
    public Integer assists;
    @SerializedName("hit_rate") public Integer hitRate;
}