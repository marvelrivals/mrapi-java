package org.mrapi.objects.player;

import com.google.gson.annotations.SerializedName;
import org.mrapi.objects.RivalDuration;
import org.mrapi.RivalObject;

public class RivalPlayerHeroStats extends RivalObject {
    @SerializedName("hero_name") public String heroName;
    public Stats unranked;
    public Stats ranked;
    public MatchUp matchup;

    public static class Stats extends RivalObject {
        public Integer matches;
        public Integer wins;
        public Integer mvp;
        public Integer svp;
        public Integer kills;
        public Integer deaths;
        public Integer assists;
        public String kdr;
        public String kda;
        @SerializedName("damage_given") public Long damageGiven;
        @SerializedName("damage_received") public Long damageReceived;
        public Long heal;
        public RivalDuration playtime;
    }

    public static class MatchUp extends RivalObject {
        public Integer matches;
        public Integer wins;
        public Number winrate;
    }
}
