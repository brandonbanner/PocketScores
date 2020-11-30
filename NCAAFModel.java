
package pocketscoresapitranslator;


public class NCAAFModel {
    
    protected SportsFeedTranslator SFAPITranslator = new SportsFeedTranslator();
    
    public NCAAFModel(String date){
        this.SFAPITranslator = new SportsFeedTranslator("NCAAF", date);
    }
    
    //=================================GETTERS=================================
    
    public int getNumGames(){
        return this.SFAPITranslator.getNumOfGames();
    }
    
    public String getStartTime(int _gameNum){
        return this.SFAPITranslator.getStartTime(_gameNum);
    }
    
    public String getStatus(int _gameNum){
        return this.SFAPITranslator.getStatus(_gameNum);
    }
    
    public String getCurrentQuarter(int _gameNum){
        return this.SFAPITranslator.getCurrentPeriod(_gameNum);
    }
    
    public String getRemainingTime(int _gameNum){
        return this.SFAPITranslator.getRemainingTime(_gameNum);
    }
    
    public String getHomeTeam(int _gameNum){
        return this.SFAPITranslator.getHomeTeamName(_gameNum);
    }
    
    public String getAwayTeam(int _gameNum){
        return this.SFAPITranslator.getAwayTeamName(_gameNum);
    }
    
    public String getHomeScore(int _gameNum){
        return this.SFAPITranslator.getHomeScore(_gameNum);
    }
    
    public String getAwayScore(int _gameNum){
        return this.SFAPITranslator.getAwayScore(_gameNum);
    }
    
    public String getFirstHomeQuarter(int _gameNum){
        return this.SFAPITranslator.getFirstQuarterHome(_gameNum);
    }
    
    public String getSecondHomeQuarter(int _gameNum){
        return this.SFAPITranslator.getSecondQuarterHome(_gameNum);
    }
    
    public String getThirdHomeQuarter(int _gameNum){
        return this.SFAPITranslator.getThirdQuarterHome(_gameNum);
    }
    
    public String getFourthHomeQuarter(int _gameNum){
        return this.SFAPITranslator.getFourthQuarterHomeFootball(_gameNum);
    }
    
    public String getFirstAwayQuarter(int _gameNum){
        return this.SFAPITranslator.getFirstQuarterAway(_gameNum);
    }
    
    public String getSecondAwayQuarter(int _gameNum){
        return this.SFAPITranslator.getSecondQuarterAway(_gameNum);
    }
    
    public String getThirdAwayQuarter(int _gameNum){
        return this.SFAPITranslator.getThirdQuarterAway(_gameNum);
    }
    
    public String getFourthAwayQuarter(int _gameNum){
        return this.SFAPITranslator.getFourthQuarterAwayFootball(_gameNum);
    }
}
