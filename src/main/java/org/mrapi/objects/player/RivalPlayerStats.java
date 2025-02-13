package org.mrapi.objects.player;

import com.google.gson.annotations.SerializedName;
import org.mrapi.objects.RivalDuration;
import org.mrapi.RivalObject;

public class RivalPlayerStats extends RivalObject {
    public String level;
    public RivalStatsRank rank;
    @SerializedName("total_matches") public Integer totalMatches;
    @SerializedName("total_wins") public Integer totalWins;
    @SerializedName("total_losses") public Integer totalLosses;
    @SerializedName("total_playtime") public RivalDuration totalPlaytime;
    public RivalStats ranked;
    public RivalStats unranked;

    public static class RivalStatsRank extends RivalObject {
        public Integer level;
        public String rank;
        public Integer score;
        @SerializedName("win_count") public Integer winCount;
    }

    public static class RivalStats extends RivalObject {
        @SerializedName("total_matches") public Integer totalMatches;
        @SerializedName("total_wins") public Integer totalWins;
        @SerializedName("total_losses") public Integer totalLosses;
        @SerializedName("total_kills") public Integer totalKills;
        @SerializedName("total_assists") public Integer totalAssists;
        @SerializedName("total_deaths") public Integer totalDeaths;
        @SerializedName("total_playtime") public RivalDuration totalPlaytime;
        public String kdr;
    }
}
