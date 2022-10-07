/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -Adarsh (adarshs@azuga.com).
 */
package com.training.day5;
import org.json.CDL;
import org.json.JSONArray;
import org.json.JSONTokener;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This class provides the weather data of all the countries which are there in the array
 */
public class RestAPI {
    public static void main(String[] args) throws IOException, InterruptedException {
        String[] cities = {"France","india","london","madrid","america","china","bangladesh","japan","berlin","australia"};

        String sb3=null;
        StringBuilder stbr = new StringBuilder();
        stbr.append("[");


        for(int i=0; i<cities.length; i++) {

            // passing the weather API
            var url="http://api.weatherapi.com/v1/current.json?key=458803e9759b4df88b3164726221409&q="+cities[i]+"&aqi=yes";

            var request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
            var client = HttpClient.newBuilder().build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String sb = response.body();
            System.out.println(sb);
            String sb1 = sb.replace("{\"location\":{", "");
//            System.out.println(sb1);
            String sb2 = sb1.replace("\"current\":{", "");
//            System.out.println(sb2);
            String sb4 = sb2.replace("{", "\"\",");
//            System.out.println(sb4);
            sb3= sb4.replace("}", "");
//            System.out.println(sb3);
            stbr.append("{");
            stbr.append(sb3);
            stbr.append("},");
            System.out.println(stbr);
        }
        stbr.append("]");

        //Write all the data in the JSON file
        try (FileWriter fw = new FileWriter("/Users/azuga/Desktop/weather.json")) {
            fw.write(stbr.toString());
            System.out.println("data is filled into the file whether.json");
        } catch (Exception e) {
            System.out.println("an error occurred while creating or writing to the file");
        }
        InputStream is = new FileInputStream("/Users/azuga/Desktop/weather.json");
        JSONTokener tokener = new JSONTokener(is);           //break a string into tokens
        JSONArray jsonArray = new JSONArray(tokener);        // convert that to jsonArray
        StringBuilder csv = new StringBuilder();
        csv.append(CDL.toString(jsonArray));
        try {
            // Convert JSONArray into csv and save the file
            Files.write(Path.of("/Users/azuga/Desktop/weather1.csv"), csv.toString().getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("completed");

    }
}
