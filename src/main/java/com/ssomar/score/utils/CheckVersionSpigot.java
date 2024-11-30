package com.ssomar.score.utils;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CheckVersionSpigot {

    public static String getNameFromJson(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder content = new StringBuilder();
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        connection.disconnect();

        JSONObject jsonObject = new JSONObject(content.toString());
        return jsonObject.getString("name");
    }

    public static String getVersionOf(String resourceId){
        try {
            String str =  getNameFromJson("https://api.spiget.org/v2/resources/"+resourceId+"/versions/latest");
            if(str.contains("[")){
                str = str.split("\\[")[0];
            }
            str = str.trim();
            return str;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}