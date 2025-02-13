package org.mrapi.objects.heroes;

import com.google.gson.JsonArray;
import com.google.gson.annotations.SerializedName;
import org.mrapi.RivalObject;

import java.util.List;

public class RivalHero extends RivalObject {
    public String id;
    public String name;
    @SerializedName("real_name") public String realName;
    public List<RivalHeroTransformation> transformations;
    @SerializedName("en_name") public String enName;
    public String description;
    public String slug;
    public String team;
    public String difficulty;
    @SerializedName("attack_type") public String attackType;
    public String role;
    @SerializedName("image_square") public String imageSquare;
    @SerializedName("image_transverse") public String imageTransverse;
    public String icon;
    public String image;
    @SerializedName("logo_small") public String logoSmall;
    public String logo;
    public List<String> skins;
    public List<RivalHeroAbility> abilities;
    public JsonArray meta;
}