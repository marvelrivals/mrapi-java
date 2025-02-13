package org.mrapi.objects.heroes;

import com.google.gson.annotations.SerializedName;
import org.mrapi.RivalObject;

public class RivalHeroSkin extends RivalObject {
    @SerializedName("hero_id") public String heroId;
    public String id;
    public String name;
    public String quality;
    public String icon;
    public String slug;
    public String description;
    public String appearance;
}