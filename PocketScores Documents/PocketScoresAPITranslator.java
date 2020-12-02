
package pocketscoresapitranslator;
/**
 * PocketScoresAPITranslator.java
 * This is a main class designed to test the models, translator, and adapter.
 * It was run several times, while games were running, before they began, and after
 * they finished. It was also used to look at canceled games. These are all of the
 * cases for our data.
 * @author George Bell
 */
public class PocketScoresAPITranslator {

    public static void main(String[] args) {
        NFLModel NFLM = new NFLModel("2020-11-30");
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
        }/*

        System.out.println();

        NCAAFModel NCAAFM = new NCAAFModel("2020-11-29");
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

        System.out.println();

        NFLModel NFLM2 = new NFLModel("");
        System.out.println(NFLM2.getNumGames());
        if(NFLM2.getNumGames() != 0){
            System.out.println(NFLM2.getStartTime(1));
            System.out.println(NFLM2.getStatus(1));
            System.out.println(NFLM2.getCurrentQuarter(1));
            System.out.println(NFLM2.getRemainingTime(1));
            System.out.println(NFLM2.getHomeTeam(1));
            System.out.println(NFLM2.getHomeScore(1));
            System.out.println(NFLM2.getAwayTeam(1));
            System.out.println(NFLM2.getAwayScore(1));
            System.out.println(NFLM2.getFirstHomeQuarter(1));
            System.out.println(NFLM2.getSecondHomeQuarter(1));
            System.out.println(NFLM2.getThirdHomeQuarter(1));
            System.out.println(NFLM2.getFourthHomeQuarter(1));
            System.out.println(NFLM2.getFirstAwayQuarter(1));
            System.out.println(NFLM2.getSecondAwayQuarter(1));
            System.out.println(NFLM2.getThirdAwayQuarter(1));
            System.out.println(NFLM2.getFourthAwayQuarter(1));
        }

        System.out.println();

        NCAAFModel NCAAFM2 = new NCAAFModel("");
        System.out.println(NCAAFM2.getNumGames());
        if(NCAAFM2.getNumGames() != 0){
            System.out.println("First NCAA football game today:");
            System.out.println(NCAAFM2.getStartTime(1));
            System.out.println(NCAAFM2.getStatus(1));
            System.out.println(NCAAFM2.getCurrentQuarter(1));
            System.out.println(NCAAFM2.getRemainingTime(1));
            System.out.println(NCAAFM2.getHomeTeam(1));
            System.out.println(NCAAFM2.getHomeScore(1));
            System.out.println(NCAAFM2.getAwayTeam(1));
            System.out.println(NCAAFM2.getAwayScore(1));
            System.out.println(NCAAFM2.getFirstHomeQuarter(1));
            System.out.println(NCAAFM2.getSecondHomeQuarter(1));
            System.out.println(NCAAFM2.getThirdHomeQuarter(1));
            System.out.println(NCAAFM2.getFourthHomeQuarter(1));
            System.out.println(NCAAFM2.getFirstAwayQuarter(1));
            System.out.println(NCAAFM2.getSecondAwayQuarter(1));
            System.out.println(NCAAFM2.getThirdAwayQuarter(1));
            System.out.println(NCAAFM2.getFourthAwayQuarter(1));
        }

        System.out.println();

        NCAAFModel NCAAFM3 = new NCAAFModel("");
        System.out.println(NCAAFM3.getNumGames());
        if(NCAAFM3.getNumGames() != 0){
            System.out.println("Second NCAA football game today:");
            System.out.println(NCAAFM3.getStartTime(2));
            System.out.println(NCAAFM3.getStatus(2));
            System.out.println(NCAAFM3.getCurrentQuarter(2));
            System.out.println(NCAAFM3.getRemainingTime(2));
            System.out.println(NCAAFM3.getHomeTeam(2));
            System.out.println(NCAAFM3.getHomeScore(2));
            System.out.println(NCAAFM3.getAwayTeam(2));
            System.out.println(NCAAFM3.getAwayScore(2));
            System.out.println(NCAAFM3.getFirstHomeQuarter(2));
            System.out.println(NCAAFM3.getSecondHomeQuarter(2));
            System.out.println(NCAAFM3.getThirdHomeQuarter(2));
            System.out.println(NCAAFM3.getFourthHomeQuarter(2));
            System.out.println(NCAAFM3.getFirstAwayQuarter(2));
            System.out.println(NCAAFM3.getSecondAwayQuarter(2));
            System.out.println(NCAAFM3.getThirdAwayQuarter(2));
            System.out.println(NCAAFM3.getFourthAwayQuarter(2));
        }*/
    }
}
