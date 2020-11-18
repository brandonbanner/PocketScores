/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pocketscoresapitranslator;

/**
 *
 * @author gscia
 */
public class PocketScoresAPITranslator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NFLModel NFLM = new NFLModel("2020-11-17");
        System.out.println(NFLM.getNumGames());
        if(NFLM.getNumGames() != 0){
            System.out.println(NFLM.getStartTime(1));
            System.out.println(NFLM.getStatus(1));
            System.out.println(NFLM.getCurrentQuarter(1));
            System.out.println(NFLM.getRemainingTime(1));
            System.out.println(NFLM.getHomeTeam(1));
            System.out.println(NFLM.getHomeScore(1));
            System.out.println(NFLM.getAwayTeam(1));
            System.out.println(NFLM.getAwayScore(1));
            System.out.println(NFLM.getFirstHomeQuarter(1));
            System.out.println(NFLM.getSecondHomeQuarter(1));
            System.out.println(NFLM.getThirdHomeQuarter(1));
            System.out.println(NFLM.getFourthHomeQuarter(1));
            System.out.println(NFLM.getFirstAwayQuarter(1));
            System.out.println(NFLM.getSecondAwayQuarter(1));
            System.out.println(NFLM.getThirdAwayQuarter(1));
            System.out.println(NFLM.getFourthAwayQuarter(1));
        }
        
        System.out.println();
        
        NCAAFModel NCAAFM = new NCAAFModel("2020-11-17");
        System.out.println(NCAAFM.getNumGames());
        if(NCAAFM.getNumGames() != 0){
            System.out.println(NCAAFM.getStartTime(1));
            System.out.println(NCAAFM.getStatus(1));
            System.out.println(NCAAFM.getCurrentQuarter(1));
            System.out.println(NCAAFM.getRemainingTime(1));
            System.out.println(NCAAFM.getHomeTeam(1));
            System.out.println(NCAAFM.getHomeScore(1));
            System.out.println(NCAAFM.getAwayTeam(1));
            System.out.println(NCAAFM.getAwayScore(1));
            System.out.println(NCAAFM.getFirstHomeQuarter(1));
            System.out.println(NCAAFM.getSecondHomeQuarter(1));
            System.out.println(NCAAFM.getThirdHomeQuarter(1));
            System.out.println(NCAAFM.getFourthHomeQuarter(1));
            System.out.println(NCAAFM.getFirstAwayQuarter(1));
            System.out.println(NCAAFM.getSecondAwayQuarter(1));
            System.out.println(NCAAFM.getThirdAwayQuarter(1));
            System.out.println(NCAAFM.getFourthAwayQuarter(1));
        }
    }
    
}
