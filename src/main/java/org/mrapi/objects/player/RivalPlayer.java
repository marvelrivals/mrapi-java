package org.mrapi.objects.player;

import com.google.gson.annotations.SerializedName;
import org.mrapi.objects.RivalDuration;
import org.mrapi.RivalObject;

import java.util.List;
import java.util.Map;

public class RivalPlayer extends RivalObject {
    @SerializedName("player_name") public String playerName;
    @SerializedName("player_uid") public Long playerId;
    @SerializedName("player_icon") public String playerIcon;
    @SerializedName("last_updated") public String lastUpdated;
    @SerializedName("player_icon_id") public String playerIconId;
    @SerializedName("is_profile_private") public Boolean isProfilePrivate;
    public String region;
    @SerializedName("achievements_completed") public String achievementsCompleted;
    public RivalPlayerTeam team;
    public RivalPlayerStats stats;
    @SerializedName("hero_stats") public Map<String, RivalPlayerHeroStats> heroStats;
    public Map<String, RivalPlayerMap> maps;
    @SerializedName("rank_history") public List<RivalPlayerRank> rankHistory;
    public List<RivalPlayerTeammate> teammates;
    @SerializedName("match_history") public List<RivalPlayerMatch> matchHistory;

    public static class RivalPlayerMap extends RivalObject {
        public String name;
        public Integer matches;
        public Integer wins;
        public String winrate;
        public Integer kills;
        public Integer deaths;
        public Integer assists;
        @SerializedName("play_time") public RivalDuration playtime;
    }
}
