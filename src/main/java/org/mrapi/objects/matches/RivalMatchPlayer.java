package org.mrapi.objects.matches;

import com.google.gson.annotations.SerializedName;
import org.mrapi.RivalObject;

import java.util.List;

public class RivalMatchPlayer extends RivalObject {
    @SerializedName("player_uid") public String playerId;
    public String name;
    @SerializedName("hero_id") public Integer heroId;
    @SerializedName("is_win") public Boolean isWin;
    public Integer kills;
    public Integer deaths;
    public Integer assists;
    @SerializedName("hero_damage") public Integer heroDamage;
    @SerializedName("hero_healed") public Integer heroHealed;
    @SerializedName("damage_taken") public Integer damageTaken;
    public List<RivalMatchHero> heroes;
}