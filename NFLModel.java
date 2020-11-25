/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocketscoresapitranslator;


public class NFLModel {
    
    sportsFeedTranslator SFAPITranslator = new sportsFeedTranslator("NFL", "");
    
    public NFLModel(String date){
        this.SFAPITranslator = new sportsFeedTranslator("NFL", date);
    }
    
    public int getNumGames(){
        return this.SFAPITranslator.getNumOfGames();
    }
    
    public String getStartTime(int gameNum){
        return this.SFAPITranslator.getStartTime(gameNum);
    }
    
    public String getStatus(int gameNum){
        return this.SFAPITranslator.getStatus(gameNum);
    }
    
    public String getCurrentQuarter(int gameNum){
        return this.SFAPITranslator.getCurrentPeriod(gameNum);
    }
    
    public String getRemainingTime(int gameNum){
        return this.SFAPITranslator.getRemainingTime(gameNum);
    }
    
    public String getHomeTeam(int gameNum){
        return this.SFAPITranslator.getHomeTeamName(gameNum);
    }
    
    public String getAwayTeam(int gameNum){
        return this.SFAPITranslator.getAwayTeamName(gameNum);
    }
    
    public String getHomeScore(int gameNum){
        return this.SFAPITranslator.getHomeScore(gameNum);
    }
    
    public String getAwayScore(int gameNum){
        return this.SFAPITranslator.getAwayScore(gameNum);
    }
    
    public String getFirstHomeQuarter(int gameNum){
        return this.SFAPITranslator.firstQuarterHome(gameNum);
    }
    
    public String getSecondHomeQuarter(int gameNum){
        return this.SFAPITranslator.secondQuarterHome(gameNum);
    }
    
    public String getThirdHomeQuarter(int gameNum){
        return this.SFAPITranslator.thirdQuarterHome(gameNum);
    }
    
    public String getFourthHomeQuarter(int gameNum){
        return this.SFAPITranslator.fourthQuarterHomeFootball(gameNum);
    }
    
    public String getFirstAwayQuarter(int gameNum){
        return this.SFAPITranslator.firstQuarterAway(gameNum);
    }
    
    public String getSecondAwayQuarter(int gameNum){
        return this.SFAPITranslator.secondQuarterAway(gameNum);
    }
    
    public String getThirdAwayQuarter(int gameNum){
        return this.SFAPITranslator.thirdQuarterAway(gameNum);
    }
    
    public String getFourthAwayQuarter(int gameNum){
        return this.SFAPITranslator.fourthQuarterAwayFootball(gameNum);
    }
}
