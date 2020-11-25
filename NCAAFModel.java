/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocketscoresapitranslator;


public class NCAAFModel {
    
    sportsFeedTranslator SFAPITranslator = new sportsFeedTranslator("NCAAF", "");
    
    public NCAAFModel(String date){
        this.SFAPITranslator = new sportsFeedTranslator("NCAAF", date);
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
        return this.SFAPITranslator.getFirstQuarterHome(gameNum);
    }
    
    public String getSecondHomeQuarter(int gameNum){
        return this.SFAPITranslator.getSecondQuarterHome(gameNum);
    }
    
    public String getThirdHomeQuarter(int gameNum){
        return this.SFAPITranslator.getThirdQuarterHome(gameNum);
    }
    
    public String getFourthHomeQuarter(int gameNum){
        return this.SFAPITranslator.getFourthQuarterHomeFootball(gameNum);
    }
    
    public String getFirstAwayQuarter(int gameNum){
        return this.SFAPITranslator.getFirstQuarterAway(gameNum);
    }
    
    public String getSecondAwayQuarter(int gameNum){
        return this.SFAPITranslator.getSecondQuarterAway(gameNum);
    }
    
    public String getThirdAwayQuarter(int gameNum){
        return this.SFAPITranslator.getThirdQuarterAway(gameNum);
    }
    
    public String getFourthAwayQuarter(int gameNum){
        return this.SFAPITranslator.getFourthQuarterAwayFootball(gameNum);
    }
}
