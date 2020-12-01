
package pocketscoresapitranslator;
/**
 * Last updated: 2020-12-01
 * This is the translator which connects to the adapter class SportsFeedAPIAdapter. It's purpose is
 * to pull specific information from the data which the adapter returns from the API.
 * Contributing authors:George Bell
 */
public class SportsFeedTranslator {

    protected String output = "";

    public SportsFeedTranslator(String _league, String _date){
        SportsFeedAPIAdapter adapter = new SportsFeedAPIAdapter(_league, _date);
        output = adapter.getAPIstring();
    }

    SportsFeedTranslator() {

    }

    //=================================GETTERS=================================

    //Gets the number of games from the String "output" and parses to an Integer.
    public int getNumOfGames(){
        String s1 = this.output;
        int start = s1.indexOf("games\":");
        int end = s1.indexOf(",", start);
        String sub1 = s1.substring(start + "games\":".length(), end);
        return Integer.parseInt(sub1);
    }

    //Gets the start time of the game corresponding to _gameNumber from the String "output" and adjusts for Eastern Standard Time.
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

    //Gets the name of the home team of the game corresponding to _gameNumber from the String "Output".
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

    //Gets the name of the visiting team of the game corresponding to _gameNumber from the String "output".
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

    //Gets the remaining time of the current quarter of the game corresponding to _gameNumber from the String "output".
    public String getRemainingTime(int _gameNumber){
        if(getStatus(_gameNumber).equals("scheduled")){
            return "15:00";
        }else if(getStatus(_gameNumber).equals("canceled")){
            return "N/A";
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

    //Gets the current status of the game corresponding to _gameNumber from the String "output".
    public String getStatus(int _gameNumber){
        String s1 = this.output;
        int index = 0;
        String search = "status\":\"";
        for(int c = 0; c < _gameNumber; c++){
            index = s1.indexOf(search, index) + search.length();
        }
        int end = s1.indexOf("\"", index);
        String sub1 = s1.substring(index, end);
        return sub1;
    }

    //Gets the current quarter number of the game corresponding to _gameNumber from the String "output".
    public String getCurrentPeriod(int _gameNumber){
        if(getStatus(_gameNumber).equals("scheduled")){
            return "1";
        }else if(getStatus(_gameNumber).equals("canceled")){
            return "N/A";
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

    //Gets the current total score of the home team of the game corresponding to _gameNumber from the String "output".
    public String getHomeScore(int _gameNumber){
        if(getStatus(_gameNumber).equals("scheduled")){
            return "0";
        }else if(getStatus(_gameNumber).equals("canceled")){
            return "N/A";
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

    //Gets the current total score of the visiting team of the game corresponding to _gameNumber from the String "output".
    public String getAwayScore(int _gameNumber){
        if(getStatus(_gameNumber).equals("scheduled")){
            return "0";
        }else if(getStatus(_gameNumber).equals("canceled")){
            return "N/A";
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

    //Gets the current score for the first quarter of the home team of the game corresponding to _gameNumber from the String "output".
    public String getFirstQuarterHome(int _gameNumber){
        if(getStatus(_gameNumber).equals("scheduled")){
            return "0";
        }else if(getStatus(_gameNumber).equals("canceled")){
            return "N/A";
        }else if(getCurrentPeriod(_gameNumber).equals("1")){
            String s1 = this.output;
            int index = 0;
            String search = "homePeriods\":[";
            for(int c = 0; c < _gameNumber; c++){
                index = s1.indexOf(search, index) + search.length();
            }
            int end = s1.indexOf("]", index);
            String sub1 = s1.substring(index, end);
            return sub1;
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

    //Gets the current score for the second quarter of the home team of the game corresponding to _gameNumber from the String "output".
    public String getSecondQuarterHome(int _gameNumber){
        if(Integer.parseInt(getCurrentPeriod(_gameNumber)) < 2){
            return "0";
        }else if(getStatus(_gameNumber).equals("canceled")){
            return "N/A";
        }else if(getCurrentPeriod(_gameNumber).equals("2")){
            String s1 = this.output;
            int index = 0;
            String search = "homePeriods\":[";
            for(int c = 0; c < _gameNumber; c++){
                index = s1.indexOf(search, index) + search.length() + getFirstQuarterHome(_gameNumber).length() + 1;
            }
            int end = s1.indexOf("]", index);
            String sub1 = s1.substring(index, end);
            return sub1;
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

    //Gets the current score for the third quarter of the home team of the game corresponding to _gameNumber from the String "output".
    public String getThirdQuarterHome(int _gameNumber){
        if(Integer.parseInt(getCurrentPeriod(_gameNumber)) < 3){
            return "0";
        }else if(getStatus(_gameNumber).equals("canceled")){
            return "N/A";
        }else if(getCurrentPeriod(_gameNumber).equals("3")){
            String s1 = this.output;
            int index = 0;
            String search = "homePeriods\":[";
            for(int c = 0; c < _gameNumber; c++){
                index = s1.indexOf(search, index) + search.length() + getFirstQuarterHome(_gameNumber).length() + 1 + getSecondQuarterHome(_gameNumber).length() + 1;
            }
            int end = s1.indexOf("]", index);
            String sub1 = s1.substring(index, end);
            return sub1;
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

    //Gets the current score for the fourth quarter of the home team of the game corresponding to _gameNumber from the String "output".
    public String getFourthQuarterHomeFootball(int _gameNumber){
        if(Integer.parseInt(getCurrentPeriod(_gameNumber)) < 4){
            return "0";
        }else if(getStatus(_gameNumber).equals("canceled")){
            return "N/A";
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

    //Gets the current score for the first quarter of the visiting team of the game corresponding to _gameNumber from the String "output".
    public String getFirstQuarterAway(int _gameNumber){
        if(getStatus(_gameNumber).equals("scheduled")){
            return "0";
        }else if(getStatus(_gameNumber).equals("canceled")){
            return "N/A";
        }else if(getCurrentPeriod(_gameNumber).equals("1")){
            String s1 = this.output;
            int index = 0;
            String search = "awayPeriods\":[";
            for(int c = 0; c < _gameNumber; c++){
                index = s1.indexOf(search, index) + search.length();
            }
            int end = s1.indexOf("]", index);
            String sub1 = s1.substring(index, end);
            return sub1;
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

    //Gets the current score for the second quarter of the visiting team of the game corresponding to _gameNumber from the String "output".
    public String getSecondQuarterAway(int _gameNumber){
        if(Integer.parseInt(getCurrentPeriod(_gameNumber)) < 2){
            return "0";
        }else if(getStatus(_gameNumber).equals("canceled")){
            return "N/A";
        }else if(getCurrentPeriod(_gameNumber).equals("2")){
            String s1 = this.output;
            int index = 0;
            String search = "awayPeriods\":[";
            for(int c = 0; c < _gameNumber; c++){
                index = s1.indexOf(search, index) + search.length() + getFirstQuarterAway(_gameNumber).length() + 1;
            }
            int end = s1.indexOf("]", index);
            String sub1 = s1.substring(index, end);
            return sub1;
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

    //Gets the current score for the third quarter of the visiting team of the game corresponding to _gameNumber from the String "output".
    public String getThirdQuarterAway(int _gameNumber){
        if(Integer.parseInt(getCurrentPeriod(_gameNumber)) < 3){
            return "0";
        }else if(getStatus(_gameNumber).equals("canceled")){
            return "N/A";
        }else if(getCurrentPeriod(_gameNumber).equals("3")){
            String s1 = this.output;
            int index = 0;
            String search = "awayPeriods\":[";
            for(int c = 0; c < _gameNumber; c++){
                index = s1.indexOf(search, index) + search.length() + getFirstQuarterAway(_gameNumber).length() + 1 + getSecondQuarterAway(_gameNumber).length() + 1;
            }
            int end = s1.indexOf("]", index);
            String sub1 = s1.substring(index, end);
            return sub1;
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

    //Gets the current score for the fourth quarter of the visiting team of the game corresponding to _gameNumber from the String "output".
    public String getFourthQuarterAwayFootball(int _gameNumber){
        if(Integer.parseInt(getCurrentPeriod(_gameNumber)) < 4){
            return "0";
        }else if(getStatus(_gameNumber).equals("canceled")){
            return "N/A";
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
