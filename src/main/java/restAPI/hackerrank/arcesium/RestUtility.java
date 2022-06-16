package restAPI.hackerrank.arcesium;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RestUtility {
    public final static String urlStr = "https://raw.githubusercontent.com/arcjsonapi/ApiSampleData/master/api/users";

    public static List<Integer> getIdForCondition(String[]inputConditions) throws IOException {

        List<Integer> ansIds = new ArrayList<>();
        String nestedPath = inputConditions[0];
        String operation = inputConditions[1];
        List<String>valueList = Arrays.asList(inputConditions[2].split(","));

        URL url = new URL(urlStr);
        HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));
        Gson gson = new Gson();
        String outputString = br.lines().reduce("",String::concat);
        JsonArray restResponse = gson.fromJson(outputString.replace("\\s",""),JsonArray.class);

         /*      while((outputString=br.readLine())!=null)
        {
            restResponse = gson.fromJson(outputString,JsonObject.class);
        }*/

        for(JsonElement userElement : restResponse)
        {
            JsonObject user = userElement.getAsJsonObject();
            //String actualValue = user.get(nestedPath).getAsString(); THIS DOES NOT WORK
            //since the question says max 2 levels of nesting this has to be treated differently
            String actualValue = retrieveMemberValue(nestedPath,user);
            switch (operation)
            {
                case "EQUALS":
                if(actualValue.equals(valueList.get(0)))
                {
                    ansIds.add(user.get("id").getAsInt());
                }
                break;

                case "IN" :
                    if(valueList.contains(actualValue))
                    {
                        ansIds.add(user.get("id").getAsInt());
                    }
                break;
            }

        }

        if (ansIds.size() == 0) {
            ansIds.add(-1);
        }
        return ansIds;
    }

    private static String retrieveMemberValue(String memberPath, JsonObject json)
    {
        //we have been told, that max nesting is 2
        String ans = null;
        JsonObject obj = json;
        if(memberPath.contains(".")) {
            String members[] = memberPath.split("\\.");
            ans = obj.getAsJsonObject(members[0]).get(members[1]).
                    getAsString();
        }
        else
        {
            ans =obj.get(memberPath).getAsString();
        }
        return ans;

    }

}

