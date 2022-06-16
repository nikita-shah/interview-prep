package restAPI.hackerrank.footballmatch;

import java.net.URL;

public class FootBallMatchService {

    RestApiCallService  restApiCallService = new RestApiCallService();
    private static final String URL_BASE = "https://jsonmock.hackerrank.com/api/football_matches";

    public static void main(String[] args)
    {
           FootBallMatchService footBallMatchService = new FootBallMatchService();
           footBallMatchService.printAllMatches(2011,"Barcelona");
    }

    private void printAllMatches(int year, String teamName)
    {
        String url1 =URL_BASE + "?year="+year+"&team1="+teamName;
        String url2 =URL_BASE + "?year="+year+"&team2="+teamName;

        restApiCallService.fetchEntireResponse(url1);
    }

}
