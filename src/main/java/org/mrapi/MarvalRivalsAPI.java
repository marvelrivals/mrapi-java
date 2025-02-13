package org.mrapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.mrapi.objects.*;
import org.mrapi.objects.battlepass.RivalBattlePass;
import org.mrapi.objects.battlepass.RivalBattlePassReward;
import org.mrapi.objects.battlepass.RivalBattlePassRewardDeserializer;
import org.mrapi.objects.heroes.RivalHero;
import org.mrapi.objects.heroes.RivalHeroSkin;
import org.mrapi.objects.heroes.RivalHeroStats;
import org.mrapi.objects.matches.RivalMatch;
import org.mrapi.objects.player.RivalPlayer;
import org.mrapi.objects.player.RivalPlayerId;
import org.mrapi.objects.player.RivalPlayerMatch;
import org.mrapi.types.*;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class MarvalRivalsAPI {
    @Nullable
    private String apiKey;
    private HttpClient httpClient;
    public static final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(RivalBattlePassReward.class, new RivalBattlePassRewardDeserializer())
            .create();
    public static final String apiUrl = "https://mrapi.org/api/";

    public MarvalRivalsAPI() {
        this.apiKey = null;
    }

    public MarvalRivalsAPI(@Nullable String apiKey) {
        this.apiKey = apiKey;
    }

    public void setApiKey(@Nullable String apiKey) {
        this.apiKey = apiKey;
    }

    @Nullable
    public String getApiKey() {
        return apiKey;
    }

    // Endpoints start ---------------------------------------------------------------------------------------------

    public List<RivalAchievement> getAchievements() throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest("achievements");
        Type listType = new TypeToken<List<RivalAchievement>>() {}.getType();
        return gson.fromJson(response.body(), listType);
    }

    public List<RivalCode> getCodes() throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest("codes");
        Type listType = new TypeToken<List<RivalCode>>() {}.getType();
        return gson.fromJson(response.body(), listType);
    }

    public List<RivalHero> getHeroes() throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest("heroes");
        Type listType = new TypeToken<List<RivalHero>>() {}.getType();
        return gson.fromJson(response.body(), listType);
    }

    public RivalHero getHero(@NotNull RivalHeroes hero) throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest("hero/"+hero.id);
        return gson.fromJson(response.body(), RivalHero.class);
    }

    public RivalHeroStats getHeroStats(@NotNull RivalPlatform platform) throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest("heroes-stats/"+platform.toString().toLowerCase());
        return gson.fromJson(response.body(), RivalHeroStats.class);
    }

    public List<RivalItem> getItems() throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest("items");
        Type listType = new TypeToken<List<RivalItem>>() {}.getType();
        return gson.fromJson(response.body(), listType);
    }

    public RivalItem getItem(@NotNull String id) throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest("item/"+id);
        return gson.fromJson(response.body(), RivalItem.class);
    }

    public List<RivalLeaderboard> getLeaderboard(@Nullable RivalHeroes hero, @Nullable RivalPlatform platform) throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest("leaderboard"+(hero!=null?"/"+hero.id:"")+(platform!=null?"?platform="+platform.toString().toLowerCase():""));
        Type listType = new TypeToken<List<RivalLeaderboard>>() {}.getType();
        return gson.fromJson(response.body(), listType);
    }

    public List<RivalMap> getMaps() throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest("maps");
        Type listType = new TypeToken<List<RivalMap>>() {}.getType();
        return gson.fromJson(response.body(), listType);
    }

    public RivalMatch getMatch(String id) throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest("match/"+id);
        return gson.fromJson(response.body(), RivalMatch.class);
    }

    public RivalPlayer getPlayer(Long id) throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest("player/"+id);
        return gson.fromJson(response.body(), RivalPlayer.class);
    }

    public RivalPlayerId getPlayerId(String name) throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest("player-id/"+name);
        return gson.fromJson(response.body(), RivalPlayerId.class);
    }

    public List<RivalPlayerMatch> getPlayerMatches(Long id) throws IOException, InterruptedException {
        return getPlayerMatches(id, 1);
    }

    public List<RivalPlayerMatch> getPlayerMatches(Long id, Integer page) throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest("player-match/"+id+"?page="+page);
        Type listType = new TypeToken<List<RivalPlayerMatch>>() {}.getType();
        return gson.fromJson(response.body(), listType);
    }

    public boolean updatePlayer(Long id) throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest("player-update/"+id);
        return gson.toJsonTree(response.body()).getAsJsonObject().get("success").getAsBoolean();
    }

    public Map<String, RivalRank> getRanks() throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest("ranks");
        Type listType = new TypeToken<Map<String, RivalRank>>() {}.getType();
        return gson.fromJson(response.body(), listType);
    }

    public List<RivalHeroSkin> getSkins() throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest("skins");
        Type listType = new TypeToken<List<RivalHeroSkin>>() {}.getType();
        return gson.fromJson(response.body(), listType);
    }

    public List<RivalHeroSkin> getSkins(RivalHeroes hero) throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest("skin/"+hero.id);
        Type listType = new TypeToken<List<RivalHeroSkin>>() {}.getType();
        return gson.fromJson(response.body(), listType);
    }

    public RivalBattlePass getBattlePass(@Nullable RivalSeason season) throws IOException, InterruptedException {
        HttpResponse<String> response = sendRequest("battlepass?season=" + (season != null ? season.toInt() : 1));
        return gson.fromJson(response.body(), RivalBattlePass.class);
    }

    // Endpoints end -----------------------------------------------------------------------------------------------

    HttpClient getHttpClient() {
        if (httpClient != null) {
            return httpClient;
        }
        httpClient = HttpClient.newHttpClient();
        return httpClient;
    }

    HttpResponse<String> sendRequest(String endpoint) throws IOException, InterruptedException {
        HttpRequest.Builder builder = HttpRequest.newBuilder().uri(URI.create(apiUrl+endpoint));
        if (apiKey != null) {
            builder.header("Authorization", "Bearer "+apiKey).header("Accept", "application/json");
        }
        return getHttpClient().send(builder.build(), HttpResponse.BodyHandlers.ofString());
    }
}