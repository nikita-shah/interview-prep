package restAPI.hackerrank.mckinsey;


import java.io.*;
        import com.google.gson.*;
        import java.util.*;
        import java.net.URL;
        import javax.net.ssl.HttpsURLConnection;


public class McKinsey
{

    /*
     * Complete the 'getTopRatedFoodOutlets' function below.
     *
     * URL for cut and paste
     * https://jsonmock.hackerrank.com/api/food_outlets?city=<city>&page=<pageNumber>
     *
     * The function is expected to return an array of strings.
     *
     * The function accepts only city argument (String).
     */

    public static List<String> getTopRatedFoodOutlets(String city) throws Exception
    {
        List<String> ans = new ArrayList<>();
        String urlStr = "https://jsonmock.hackerrank.com/api/food_outlets?city="+city;
        Gson gson = new Gson ();

        int total_pages = 1;
        int curr_page = 1;
        JsonArray data = new JsonArray();
        while (curr_page<=total_pages)
        {
            String urlStrForPage  = urlStr + "&page=" +curr_page;
            URL url = new URL(urlStrForPage);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
            JsonObject jsonObj = gson.fromJson(br.lines().reduce("",String::concat),JsonObject.class);

            /*String response;
            while(null != (response = br.readLine())  )
            {
                JsonObject jsonObject = new Gson().fromJson(response, JsonObject.class);
                total_pages = jsonObject.get("total_pages").getAsInt();
                data.addAll(jsonObject.getAsJsonArray("data"));
            }
             */
            total_pages = jsonObj.get("total_pages").getAsInt();
            data.addAll(jsonObj.getAsJsonArray("data"));
            curr_page++;
        }
        double max = Integer.MIN_VALUE * 1.0d;
        for(JsonElement ele:data)
        {

            max = Math.max(max,ele.getAsJsonObject().getAsJsonObject("user_rating").get("average_rating").getAsDouble());
        }

        for(JsonElement ele:data)
        {
            if(ele.getAsJsonObject().getAsJsonObject("user_rating").get("average_rating").getAsDouble() == max)
            {
                ans.add(ele.getAsJsonObject().get("name").getAsString());
            }
        }

        return ans;
    }

}


