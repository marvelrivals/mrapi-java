package org.mrapi.objects.matches;

import com.google.gson.annotations.SerializedName;
import org.mrapi.RivalObject;

import java.util.List;

public class RivalMatch extends RivalObject {
    @SerializedName("match_uid") public String matchId;
    @SerializedName("replay_id") public String replayId;
    @SerializedName("mvp") public RivalSimpleMatchPlayer mvpPlayer;
    @SerializedName("svp") public RivalSimpleMatchPlayer svpPlayer;
    public RivalMatchGameMode gamemode;
    public List<RivalMatchPlayer> players;
}