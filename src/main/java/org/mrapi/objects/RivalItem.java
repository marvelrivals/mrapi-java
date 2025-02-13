package org.mrapi.objects;

import com.google.gson.annotations.SerializedName;
import org.mrapi.RivalObject;

public class RivalItem extends RivalObject {
    public String id;
    public String name;
    public String quality;
    public String type;
    @SerializedName("applicable_hero") public String applicableHero;
    public String icon;
    public String slug;
    public String description;
}