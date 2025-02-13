package org.mrapi.types;

public enum RivalSeason {
    SEASON_0,
    SEASON_1;

    public Integer toInt() {
        return Integer.parseInt(this.name().split("SEASON_")[1]);
    }
}
