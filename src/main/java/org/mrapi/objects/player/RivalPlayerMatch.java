package org.mrapi.objects.player;

import com.google.gson.annotations.SerializedName;
import org.mrapi.objects.RivalDuration;
import org.mrapi.RivalObject;

public class RivalPlayerMatch extends RivalObject {
    @SerializedName("match_timestamp") public Long matchTimestamp;
    @SerializedName("match_duration") public RivalDuration matchDuration;
    public String season;
    @SerializedName("match_id") public String matchId;
    @SerializedName("match_map") public MatchMap matchMap;
    public MatchScore score;
    public Integer winnerSide;
    @SerializedName("mvp_uid") public Long mvpId;
    @SerializedName("svp_uid") public Long svpId;
    public MatchGamemode gamemode;
    public MatchStats stats;

    public static class MatchMap extends RivalObject {
        public Integer id;
        public String name;
        public String gamemode;
    }

    public static class MatchScore extends RivalObject {
        public Integer allay;
        public Integer enemy;
    }

    public static class MatchGamemode extends RivalObject {
        public Integer id;
        public String name;
    }

    public static class MatchStats extends RivalObject {
        public Integer kills;
        public Integer deaths;
        public Integer assists;
        @SerializedName("is_win") public Boolean isWin;
        @SerializedName("has_escaped") public Boolean hasEscaped;
        public MatchHero hero;

        public static class MatchHero extends RivalObject {
            public Integer id;
        }
    }
}
