package org.mrapi.objects.battlepass;

import com.google.gson.annotations.SerializedName;
import org.mrapi.RivalObject;

import java.util.List;

public class RivalBattlePass extends RivalObject {
    @SerializedName("start_time") public Long startTime;
    @SerializedName("end_time") public Long endTime;
    public List<RivalBattlePassPage> pages;
}