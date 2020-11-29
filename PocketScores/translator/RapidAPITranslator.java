
package PocketScores.translator;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


class RapidAPITranslator {
    public String output = "";
    
    public RapidAPITranslator(String league, String date){
        String baseUrl = "https://rapidapi.p.rapidapi.com/games?league=";
        String urlString = baseUrl + league + "&date=" + date;
        URL url;
        try {

            url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("x-rapidapi-key","b5e4c2346emsh81375d22c74af66p13552ejsn6edf8a56cdad");
            con.setRequestProperty("x-rapidapi-host","sportspage-feeds.p.rapidapi.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            this.output = content.toString();
            //System.out.println("Output: " + content.toString());
        } catch (Exception ex) {
            //Logger.getLogger(DemoAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getNumOfGames(){
        String s1 = this.output;
        int start = s1.indexOf("games\":");
        int end = s1.indexOf(",", start);
        String sub1 = s1.substring(start + 7, end);
        return Integer.parseInt(sub1);
    }
    
    public String getStartTime(int gameNumber){
        String s1 = this.output;
        int index = 0;
        String search = "\"date\"";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length();
        }
        int start = s1.indexOf("T", index);
        int end = s1.indexOf(".", start);
        String sub1 = s1.substring(start + 1, end);
        return sub1;
    }
    
    public String getHomeTeamName(int gameNumber){
        String s1 = this.output;
        int index = 0;
        String search = "home\":{\"team\":\"";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length();
        }
        int end = s1.indexOf("\"", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getAwayTeamName(int gameNumber){
        String s1 = this.output;
        int index = 0;
        String search = "away\":{\"team\":\"";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length();
        }
        int end = s1.indexOf("\"", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getRemainingTime(int gameNumber){
        if(getStatus(gameNumber).equals("scheduled")){
            return "15:00";
        }
        String s1 = this.output;
        int index = 0;
        String search = "periodTimeRemaining\":\"";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length();
        }
        int end = s1.indexOf("\"", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getStatus(int gameNumber){
        String s1 = this.output;
        int index = 0;
        String search = "status\":";
        for(int c = 0; c < gameNumber + 1; c++){
            index = s1.indexOf(search, index) + search.length();
        }
        int end = s1.indexOf("\"", index+1);
        String sub1 = s1.substring(index+1, end);
        return sub1;
    }
    
    public String getCurrentPeriod(int gameNumber){
        if(getStatus(gameNumber).equals("scheduled")){
            return "1";
        }
        String s1 = this.output;
        int index = 0;
        String search = "currentPeriod\":";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length();
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getHomeScore(int gameNumber){
        if(getStatus(gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "score\":{\"away\":";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + 8 + getAwayScore(gameNumber).length();
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getAwayScore(int gameNumber){
        if(getStatus(gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "score\":{\"away\":";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length();
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String firstQuarterHome(int gameNumber){
        if(getStatus(gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "homePeriods\":[";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length();
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String secondQuarterHome(int gameNumber){
        if(getStatus(gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "homePeriods\":[";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + firstQuarterHome(gameNumber).length() + 1;
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String thirdQuarterHome(int gameNumber){
        if(getStatus(gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "homePeriods\":[";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + firstQuarterHome(gameNumber).length() + 1 + secondQuarterHome(gameNumber).length() + 1;
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String fourthQuarterHomeFootball(int gameNumber){
        if(getStatus(gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "homePeriods\":[";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + firstQuarterHome(gameNumber).length() + 1 + secondQuarterHome(gameNumber).length() + 1 + thirdQuarterHome(gameNumber).length() + 1;
        }
        int end = s1.indexOf("]", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String firstQuarterAway(int gameNumber){
        if(getStatus(gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "awayPeriods\":[";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length();
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String secondQuarterAway(int gameNumber){
        if(getStatus(gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "awayPeriods\":[";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + firstQuarterAway(gameNumber).length() + 1;
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String thirdQuarterAway(int gameNumber){
        if(getStatus(gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "awayPeriods\":[";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + firstQuarterAway(gameNumber).length() + 1 + secondQuarterAway(gameNumber).length() + 1;
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String fourthQuarterAwayFootball(int gameNumber){
        if(getStatus(gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "awayPeriods\":[";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + firstQuarterAway(gameNumber).length() + 1 + secondQuarterAway(gameNumber).length() + 1 + thirdQuarterAway(gameNumber).length() + 1;
        }
        int end = s1.indexOf("]", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
}
