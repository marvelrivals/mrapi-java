package org.mrapi.objects.player;

import com.google.gson.annotations.SerializedName;
import org.mrapi.RivalObject;

public class RivalPlayerRank extends RivalObject {
    public Long timestamp;
    public Rank rank;

    public static class Rank extends RivalObject {
        @SerializedName("old_score") public Integer oldScore;
        @SerializedName("old_rank") public String oldRank;
        @SerializedName("old_level") public Integer oldLevel;
        @SerializedName("new_score") public Integer newScore;
        @SerializedName("new_rank") public String newRank;
        @SerializedName("new_level") public Integer newLevel;
    }
}
