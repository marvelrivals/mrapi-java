package org.mrapi.objects.heroes;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import org.mrapi.RivalObject;

public class RivalHeroAbility extends RivalObject {
    public Integer id;
    public String icon;
    public String name;
    public String type;
    public boolean isCollab;
    public String description;
    @SerializedName("additional_fields") public JsonObject additionalFields;
    public Integer transformation_id;
}