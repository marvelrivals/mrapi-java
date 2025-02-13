package org.mrapi.objects;

import com.google.gson.annotations.SerializedName;
import org.mrapi.RivalObject;

import java.util.List;

public class RivalMap extends RivalObject {
    public String name;
    @SerializedName("full_name") public String fullName;
    public String location;
    public Integer id;
    public String description;
    public List<String> images;
    public String video;
    @SerializedName("is_competitve") public Boolean isCompetitive;
    public String gamemode;
}