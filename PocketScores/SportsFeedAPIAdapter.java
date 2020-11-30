
package PocketScores;

/**
 * Last updated: 2020-11-30
 * This is the adapter which connects to the API PocketScores. It's purpose is
 * to pull game data from the API.
 * Contributing authors: Clayton Winters
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SportsFeedAPIAdapter {
    
    protected String output = "";
    
    public SportsFeedAPIAdapter(String _league, String _date){
         String baseUrl = "https://rapidapi.p.rapidapi.com/games?league=";
        String urlString = baseUrl + _league + "&date=" + _date;
        URL url;
        try {

            url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("x-rapidapi-key","b5e4c2346emsh81375d22c74af66p13552ejsn6edf8a56cdad");
            con.setRequestProperty("x-rapidapi-host","sportspage-feeds.p.rapidapi.com");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            con.disconnect();
            this.output = content.toString();
            //System.out.println("Output: " + content.toString());
        } catch (Exception ex) {
            //Logger.getLogger(DemoAPI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //==================================GETTER==================================
    
    public String getAPIstring(){
        return this.output;
    }
}