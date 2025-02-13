package org.mrapi.objects;

import com.google.gson.annotations.SerializedName;
import org.mrapi.RivalObject;

public class RivalRank extends RivalObject {
    @SerializedName("1") public Integer one;
    @SerializedName("2") public Integer two;
    @SerializedName("3") public Integer three;
    public Integer total;
    public String image;
}
