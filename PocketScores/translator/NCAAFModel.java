package PocketScores.translator;

public class NCAAFModel {
     RapidAPITranslator RAPIT = new RapidAPITranslator("NCAAF", "");
    
    public NCAAFModel(String date){
        this.RAPIT = new RapidAPITranslator("NCAAF", date);
    }
    
    public int getNumGames(){
        return this.RAPIT.getNumOfGames();
    }
    
    public String getStartTime(int gameNum){
        return this.RAPIT.getStartTime(gameNum);
    }
    
    public String getStatus(int gameNum){
        return this.RAPIT.getStatus(gameNum);
    }
    
    public String getCurrentQuarter(int gameNum){
        return this.RAPIT.getCurrentPeriod(gameNum);
    }
    
    public String getRemainingTime(int gameNum){
        return this.RAPIT.getRemainingTime(gameNum);
    }
    
    public String getHomeTeam(int gameNum){
        return this.RAPIT.getHomeTeamName(gameNum);
    }
    
    public String getAwayTeam(int gameNum){
        return this.RAPIT.getAwayTeamName(gameNum);
    }
    
    public String getHomeScore(int gameNum){
        return this.RAPIT.getHomeScore(gameNum);
    }
    
    public String getAwayScore(int gameNum){
        return this.RAPIT.getAwayScore(gameNum);
    }
    
    public String getFirstHomeQuarter(int gameNum){
        return this.RAPIT.firstQuarterHome(gameNum);
    }
    
    public String getSecondHomeQuarter(int gameNum){
        return this.RAPIT.secondQuarterHome(gameNum);
    }
    
    public String getThirdHomeQuarter(int gameNum){
        return this.RAPIT.thirdQuarterHome(gameNum);
    }
    
    public String getFourthHomeQuarter(int gameNum){
        return this.RAPIT.fourthQuarterHomeFootball(gameNum);
    }
    
    public String getFirstAwayQuarter(int gameNum){
        return this.RAPIT.firstQuarterAway(gameNum);
    }
    
    public String getSecondAwayQuarter(int gameNum){
        return this.RAPIT.secondQuarterAway(gameNum);
    }
    
    public String getThirdAwayQuarter(int gameNum){
        return this.RAPIT.thirdQuarterAway(gameNum);
    }
    
    public String getFourthAwayQuarter(int gameNum){
        return this.RAPIT.fourthQuarterAwayFootball(gameNum);
    }
}
