package org.mrapi.objects.player;

import org.mrapi.RivalObject;

public class RivalPlayerTeammate extends RivalObject {
    public String name;
    public String playerId;
    public Stats stats;

    public static class Stats extends RivalObject {
        public Integer wins;
        public Integer matches;
    }
}
