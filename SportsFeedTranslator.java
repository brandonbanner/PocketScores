
package pocketscoresapitranslator;

public class SportsFeedTranslator {
    
    protected String output = "";
    
    public SportsFeedTranslator(String _league, String _date){
        SportsFeedAPIAdapter adapter = new SportsFeedAPIAdapter(_league, _date);
        output = adapter.getAPIstring();
    }
    
    //=================================GETTERS=================================
    
    public int getNumOfGames(){
        String s1 = this.output;
        int start = s1.indexOf("games\":");
        int end = s1.indexOf(",", start);
        String sub1 = s1.substring(start + "games\":".length(), end);
        return Integer.parseInt(sub1);
    }
    
    public String getStartTime(int _gameNumber){
        String s1 = this.output;
        int index = 0;
        String search = "\"date\"";
        for(int c = 0; c < _gameNumber; c++){
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
    
    public String getHomeTeamName(int _gameNumber){
        String s1 = this.output;
        int index = 0;
        String search = "home\":{\"team\":\"";
        for(int c = 0; c < _gameNumber; c++){
            index = s1.indexOf(search, index) + search.length();
        }
        int end = s1.indexOf("\"", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getAwayTeamName(int _gameNumber){
        String s1 = this.output;
        int index = 0;
        String search = "away\":{\"team\":\"";
        for(int c = 0; c < _gameNumber; c++){
            index = s1.indexOf(search, index) + search.length();
        }
        int end = s1.indexOf("\"", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getRemainingTime(int _gameNumber){
        if(getStatus(_gameNumber).equals("scheduled")){
            return "15:00";
        }
        String s1 = this.output;
        int index = 0;
        String search = "periodTimeRemaining\":\"";
        for(int c = 0; c < _gameNumber; c++){
            index = s1.indexOf(search, index) + search.length();
        }
        int end = s1.indexOf("\"", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getStatus(int _gameNumber){
        String s1 = this.output;
        int index = 0;
        String search = "status\":";
        for(int c = 0; c < _gameNumber + 1; c++){
            index = s1.indexOf(search, index) + search.length();
        }
        int end = s1.indexOf("\"", index+1);
        String sub1 = s1.substring(index+1, end);
        return sub1;
    }
    
    public String getCurrentPeriod(int _gameNumber){
        if(getStatus(_gameNumber).equals("scheduled")){
            return "1";
        }
        String s1 = this.output;
        int index = 0;
        String search = "currentPeriod\":";
        for(int c = 0; c < _gameNumber; c++){
            index = s1.indexOf(search, index) + search.length();
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getHomeScore(int _gameNumber){
        if(getStatus(_gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "score\":{\"away\":";
        for(int c = 0; c < _gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + 8 + getAwayScore(_gameNumber).length();
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getAwayScore(int _gameNumber){
        if(getStatus(_gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "score\":{\"away\":";
        for(int c = 0; c < _gameNumber; c++){
            index = s1.indexOf(search, index) + search.length();
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getFirstQuarterHome(int _gameNumber){
        if(getStatus(_gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "homePeriods\":[";
        for(int c = 0; c < _gameNumber; c++){
            index = s1.indexOf(search, index) + search.length();
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getSecondQuarterHome(int _gameNumber){
        if(getStatus(_gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "homePeriods\":[";
        for(int c = 0; c < _gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + getFirstQuarterHome(_gameNumber).length() + 1;
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getThirdQuarterHome(int _gameNumber){
        if(getStatus(_gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "homePeriods\":[";
        for(int c = 0; c < _gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + getFirstQuarterHome(_gameNumber).length() + 1 + getSecondQuarterHome(_gameNumber).length() + 1;
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getFourthQuarterHomeFootball(int _gameNumber){
        if(getStatus(_gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "homePeriods\":[";
        for(int c = 0; c < _gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + getFirstQuarterHome(_gameNumber).length() + 1 + getSecondQuarterHome(_gameNumber).length() + 1 + getThirdQuarterHome(_gameNumber).length() + 1;
        }
        int end = s1.indexOf("]", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getFirstQuarterAway(int _gameNumber){
        if(getStatus(_gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "awayPeriods\":[";
        for(int c = 0; c < _gameNumber; c++){
            index = s1.indexOf(search, index) + search.length();
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getSecondQuarterAway(int _gameNumber){
        if(getStatus(_gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "awayPeriods\":[";
        for(int c = 0; c < _gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + getFirstQuarterAway(_gameNumber).length() + 1;
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getThirdQuarterAway(int _gameNumber){
        if(getStatus(_gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "awayPeriods\":[";
        for(int c = 0; c < _gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + getFirstQuarterAway(_gameNumber).length() + 1 + getSecondQuarterAway(_gameNumber).length() + 1;
        }
        int end = s1.indexOf(",", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
    public String getFourthQuarterAwayFootball(int _gameNumber){
        if(getStatus(_gameNumber).equals("scheduled")){
            return "0";
        }
        String s1 = this.output;
        int index = 0;
        String search = "awayPeriods\":[";
        for(int c = 0; c < _gameNumber; c++){
            index = s1.indexOf(search, index) + search.length() + getFirstQuarterAway(_gameNumber).length() + 1 + getSecondQuarterAway(_gameNumber).length() + 1 + getThirdQuarterAway(_gameNumber).length() + 1;
        }
        int end = s1.indexOf("]", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }
    
}
