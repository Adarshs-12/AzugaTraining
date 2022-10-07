package com.training.day5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVtoHTML {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("/Users/azuga/Desktop/weather1.csv"))) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {

                String s = currentLine.replace("//cdn.weatherapi.com","<img src=https://cdn.weatherapi.com/");
                String s1 = s.replace("png","png style=\"width:50px;height:50px;\"");
                lines.add(s1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //embrace <td> and <tr> for lines and columns
        for (int i = 0; i < lines.size(); i++) {
            lines.set(i, "<tr><td>" + lines.get(i) + "</td></tr>");
            lines.set(i, lines.get(i).replaceAll(",", "</td><td>"));
        }


        lines.set(0, "<table border>" + lines.get(0));
        lines.set(lines.size() - 1, lines.get(lines.size() - 1) + "</table>");

        // output result
        try (FileWriter writer = new FileWriter("/Users/azuga/Desktop/converted.html")) {
            for (String line : lines) {
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
