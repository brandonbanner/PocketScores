/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocketscoresapitranslator;

public class sportsFeedTranslator {
    
    public String output = "";
    
    public sportsFeedTranslator(String league, String date){
        sportsFeedAPIAdapter adapter = new sportsFeedAPIAdapter(league, date);
        output = adapter.getAPIstring();
    }
    
    public int getNumOfGames(){
        String s1 = this.output;
        int start = s1.indexOf("games\":");
        int end = s1.indexOf(",", start);
        String sub1 = s1.substring(start + "games\":".length(), end);
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
        String sub2 = sub1.substring(0, 2);
        int timeDiff = Integer.parseInt(sub2);
        timeDiff = (timeDiff + 19) % 24;
        String correctTime = timeDiff + "" + sub1.substring(2, sub1.length());
        return correctTime;
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
    
    public String getFirstQuarterHome(int gameNumber){
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
    
    public String getSecondQuarterHome(int gameNumber){
        if(getStatus(gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "homePeriods\":[";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + getFirstQuarterHome(gameNumber).length() + 1;
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getThirdQuarterHome(int gameNumber){
        if(getStatus(gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "homePeriods\":[";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + getFirstQuarterHome(gameNumber).length() + 1 + getSecondQuarterHome(gameNumber).length() + 1;
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getFourthQuarterHomeFootball(int gameNumber){
        if(getStatus(gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "homePeriods\":[";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + getFirstQuarterHome(gameNumber).length() + 1 + getSecondQuarterHome(gameNumber).length() + 1 + getThirdQuarterHome(gameNumber).length() + 1;
        }
        int end = s1.indexOf("]", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getFirstQuarterAway(int gameNumber){
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
    
    public String getSecondQuarterAway(int gameNumber){
        if(getStatus(gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "awayPeriods\":[";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + getFirstQuarterAway(gameNumber).length() + 1;
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getThirdQuarterAway(int gameNumber){
        if(getStatus(gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "awayPeriods\":[";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + getFirstQuarterAway(gameNumber).length() + 1 + getSecondQuarterAway(gameNumber).length() + 1;
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getFourthQuarterAwayFootball(int gameNumber){
        if(getStatus(gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "awayPeriods\":[";
        for(int c = 0; c < gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + getFirstQuarterAway(gameNumber).length() + 1 + getSecondQuarterAway(gameNumber).length() + 1 + getThirdQuarterAway(gameNumber).length() + 1;
        }
        int end = s1.indexOf("]", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
}
