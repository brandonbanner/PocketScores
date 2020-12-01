
package pocketscoresapitranslator;
/**
 * Last updated: 2020-12-01
 * This is the model for the NFL game. It's purpose is to handle the data
 * returned from the translator. This app simply displays data without altering
 * it; the methods here only call and return the output of methods from the
 * translator, SportsFeedTranslator.
 * Contributing authors:George Bell
 */
public class NFLModel {

    protected SportsFeedTranslator SFAPITranslator = new SportsFeedTranslator();

    public NFLModel(String date){
        this.SFAPITranslator = new SportsFeedTranslator("NFL", date);
    }

    //=================================GETTERS=================================

    //Gets the number of games.
    public int getNumGames(){
        return this.SFAPITranslator.getNumOfGames();
    }

    //Gets the starting time of the game corresponding to _gameNum.
    public String getStartTime(int _gameNum){
        return this.SFAPITranslator.getStartTime(_gameNum);
    }

    //Gets the status of the game corresponding to _gameNum.
    public String getStatus(int _gameNum){
        return this.SFAPITranslator.getStatus(_gameNum);
    }

    //Gets the current quarter number of the game corresponding to _gameNum.
    public String getCurrentQuarter(int _gameNum){
        return this.SFAPITranslator.getCurrentPeriod(_gameNum);
    }

    //Gets the remaining time of the current quarter of the game corresponding to _gameNum.
    public String getRemainingTime(int _gameNum){
        return this.SFAPITranslator.getRemainingTime(_gameNum);
    }

    //Gets the name of the home team of the game corresponding to _gameNum.
    public String getHomeTeam(int _gameNum){
        return this.SFAPITranslator.getHomeTeamName(_gameNum);
    }

    //Gets the name of the visiting team of the game corresponding to _gameNum.
    public String getAwayTeam(int _gameNum){
        return this.SFAPITranslator.getAwayTeamName(_gameNum);
    }

    //Gets the current total score of the home team of the game corresponding to _gameNum.
    public String getHomeScore(int _gameNum){
        return this.SFAPITranslator.getHomeScore(_gameNum);
    }

    //Gets the current total score of the visiting team of the game corresponding to _gameNum.
    public String getAwayScore(int _gameNum){
        return this.SFAPITranslator.getAwayScore(_gameNum);
    }

    //Gets the current score of the first quarter of the home team of the game corresponding to _gameNum.
    public String getFirstHomeQuarter(int _gameNum){
        return this.SFAPITranslator.getFirstQuarterHome(_gameNum);
    }

    //Gets the current score of the second quarter of the home team of the game corresponding to _gameNum.
    public String getSecondHomeQuarter(int _gameNum){
        return this.SFAPITranslator.getSecondQuarterHome(_gameNum);
    }

    //Gets the current score of the third quarter of the home team of the game corresponding to _gameNum.
    public String getThirdHomeQuarter(int _gameNum){
        return this.SFAPITranslator.getThirdQuarterHome(_gameNum);
    }

    //Gets the current score of the fourth quarter of the home team of the game corresponding to _gameNum.
    public String getFourthHomeQuarter(int _gameNum){
        return this.SFAPITranslator.getFourthQuarterHomeFootball(_gameNum);
    }

    //Gets the current score of the first quarter of the visiting team of the game corresponding to _gameNum.
    public String getFirstAwayQuarter(int _gameNum){
        return this.SFAPITranslator.getFirstQuarterAway(_gameNum);
    }

    //Gets the current score of the second quarter of the visiting team of the game corresponding to _gameNum.
    public String getSecondAwayQuarter(int _gameNum){
        return this.SFAPITranslator.getSecondQuarterAway(_gameNum);
    }

    //Gets the current score of the third quarter of the visiting team of the game corresponding to _gameNum.
    public String getThirdAwayQuarter(int _gameNum){
        return this.SFAPITranslator.getThirdQuarterAway(_gameNum);
    }

    //Gets the current score of the fourth quarter of the visiting team of the game corresponding to _gameNum.
    public String getFourthAwayQuarter(int _gameNum){
        return this.SFAPITranslator.getFourthQuarterAwayFootball(_gameNum);
    }
}
