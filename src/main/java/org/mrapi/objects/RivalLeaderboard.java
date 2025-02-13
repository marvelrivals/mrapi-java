package org.mrapi.objects;

import com.google.gson.annotations.SerializedName;
import org.mrapi.RivalObject;

public class RivalLeaderboard extends RivalObject {
    public Integer rank;
    @SerializedName("player_name") public String playerName;
    @SerializedName("rank_name") public String rankName;
    public Long score;
    public Integer matches;
    @SerializedName("player_id") public Long playerId;
}