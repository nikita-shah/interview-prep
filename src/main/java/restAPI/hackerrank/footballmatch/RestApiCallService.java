package restAPI.hackerrank.footballmatch;

import com.google.gson.*;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class  RestApiCallService {

    private  int totalPages = 1;

    public JsonArray fetchEntireResponse(String url)
    {
        int currPage = 1;

        JsonArray response = new JsonArray();
        while( currPage <=  totalPages)
        {
            JsonArray pageResponse = fetchJsonResponseForAPage(url,currPage);
            response.addAll(pageResponse);
            currPage++;
        }

        System.out.println(response.toString());
         return response;
    }

    public JsonArray fetchJsonResponseForAPage(String url, int page)
    {
        String response;
        JsonArray result = new JsonArray() ;
        try
        {
            URL urlforPage = new URL(url+ "&page=" + page);
            HttpsURLConnection con = (HttpsURLConnection) urlforPage.openConnection();
            con.setRequestMethod("GET");

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            while(null != (response = br.readLine())  )
            {
                JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
                totalPages = jsonObject.get("total_pages").getAsInt();
                result.addAll(jsonObject.getAsJsonArray("data"));
            }
            Set<String> set = new HashSet<String>();


        } catch (MalformedURLException e) {
            System.out.println("Error in the url "+e.getLocalizedMessage());
        } catch (IOException e) {
            System.out.println("Error comunicating to upline server!" + e.getLocalizedMessage());
        }

        return result;
    }
}
