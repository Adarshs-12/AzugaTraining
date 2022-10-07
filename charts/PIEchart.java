/*
 * Copyright (c) 2022.  - All Rights Reserved
 *  * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 *  * is strictly prohibited-
 *  * @Author -Adarsh
 */
package com.training.week2;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.swing.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import org.apache.log4j.Logger;

public class PIEchart extends JFrame {

    static final Logger log = Logger.getLogger(PIEchart.class);
    private static final long serialVersionUID = 6294689542092367723L;

    public PIEchart(String pieChartTitle) throws IOException {

        super(pieChartTitle);
        log.info("PIEchart method is invoked");
        // Create piedata
        PieDataset piedata = createDataset();

        // Create chart
        JFreeChart chart = ChartFactory.createPieChart(
                "percentage of Types of items in store",
                piedata,
                true,
                true,
                false);

        //Format Label
        PieSectionLabelGenerator sectionLabelGenerator = new StandardPieSectionLabelGenerator(
                " {0} : ({2})", new DecimalFormat("0"), new DecimalFormat("0%"));
        ((PiePlot<?>) chart.getPlot()).setLabelGenerator(sectionLabelGenerator);

        // Create Panel
        ChartPanel chartPanel = new ChartPanel(chart);
        setContentPane(chartPanel);

        log.info("FakeStore PieChart() is executed");

    }

    private PieDataset createDataset() throws IOException {
        List<String> category=new ArrayList<>();
        log.info("Data fetched from the FakeStore JSON file");
        String loc = "/users/azuga/desktop/fakestore.json";         //fetch the data from the JSON file
        String result = new String(Files.readAllBytes(Paths.get(loc)));
        JSONArray arr=new JSONArray(result);
        for (Object obj : arr){
            log.debug("Object Data" + obj);
            JSONObject jo= (JSONObject) obj;
            Iterator<?> keys;
            keys = jo.keys();
            while (keys.hasNext()){
                String s=(String)keys.next();
                if ((s.equals("category"))) {
                    category.add((String) jo.get(s));
                }
            }
        }
        log.info("Creating Dataset");
        HashMap<String, Integer> languageMap =new HashMap<>();
        for (String s : category ){
            if (languageMap.containsKey(s)){
                int c=languageMap.get(s);
                languageMap.replace(s,c+1);
            }
            else{
                languageMap.put(s,1);
            }
        }
        DefaultPieDataset dataset=new DefaultPieDataset();
        Iterator iterator = languageMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry mapElement = (Map.Entry)iterator.next();
            dataset.setValue((Comparable) mapElement.getKey(), (Number) mapElement.getValue());
        }


        return dataset;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PIEchart example;
            try {
                example = new PIEchart("Pie Chart");      //enter the title of the PIE chart
            } catch (IOException e) {
                log.error("error " + e.getMessage());
                throw new RuntimeException(e);
            }
            example.setSize(700, 400);
            example.setLocationRelativeTo(null);
            example.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            example.setVisible(true);
        });
    }
}