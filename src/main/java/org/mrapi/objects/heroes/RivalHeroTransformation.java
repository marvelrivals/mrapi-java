package org.mrapi.objects.heroes;

import com.google.gson.annotations.SerializedName;
import org.mrapi.RivalObject;

public class RivalHeroTransformation extends RivalObject {
    public Integer id;
    public String icon;
    public String name;
    public String health;
    @SerializedName("movement_speed") public String movementSpeed;
}