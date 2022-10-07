/*
        * Copyright (c) 2022.  - All Rights Reserved
        * Unauthorized copying or redistribution of this file in source and binary forms via any medium
        * is strictly prohibited-
        * @Author -Adarsh (adarshs@azuga.com).
 */
package com.training.day5;

import au.com.bytecode.opencsv.CSVReader;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OopsClass implements Converter {

    private static String format(String xml) {

        try {
            final InputSource src = new InputSource(new StringReader(xml));
            final Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();
            final Boolean keepDeclaration = xml.startsWith("<?xml");


            final DOMImplementationRegistry registry = DOMImplementationRegistry.newInstance();
            final DOMImplementationLS impl = (DOMImplementationLS) registry.getDOMImplementation("LS");
            final LSSerializer writer = impl.createLSSerializer();

            writer.getDomConfig().setParameter("format-pretty-print", Boolean.TRUE); // Set this to true if the output needs to be beautified.
            writer.getDomConfig().setParameter("xml-declaration", keepDeclaration); // Set this to true if the declaration is needed to be outputted.

            return writer.writeToString(document);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * method for converting JSOn data into XML
     *
     * @param jsonString -json string as input
     * @return - returns xml as a string
     * @throws JSONException - to handle syntax error of json string
     */
    private static String convertToXML(String jsonString) throws JSONException {    // handle JSONException
        JSONObject jsonObject = new JSONObject(jsonString);
        String unformattedXml = "<" + "root" + ">" + XML.toString(jsonObject) + "</" + "root" + ">";
        return format(unformattedXml);
    }
    @Override
    public void jsontoxml() throws JSONException {
        StringBuilder sb = new StringBuilder();
        sb.append("<?xml version=\"1.0\" encoding=\"ISO-8859-15\"?>\n");
        sb.append("<roots>");
        String result;
        try {
            result = new String(Files.readAllBytes(Paths.get("/Users/azuga/Desktop/weather.json")));
            System.out.println(result);
            String a = result.replace("[","");
//             a = result.replace("]","");
            String b = a.replace("//","");



            String[] arr = b.split("},\\{");

            FileWriter file = new FileWriter("/Users/azuga/Desktop/weatherxml.xml");

            for(int i=0;i< arr.length;i++) {
                if(i==0) {
                    sb.append(convertToXML(arr[i] + "}"));// This method converts json object to xml string
                }
                else if (i==arr.length-1) {
//                    System.out.println(arr[i].charAt(arr[i].length()-1));
                    result="{"+arr[i];
                    sb.append(convertToXML(result));//file.append(convertToXML(arr[i], "root"));
//                    System.out.println("hey!!!");
                }
                else{
                    System.out.println(i);
                    result="{"+arr[i]+"}";
                    sb.append(convertToXML(result));

                }
            }
            sb.append("</roots>");
            file.write(sb.toString());
            System.out.println("Your XML data is successfully written into XMLData.txt");
            // close FileWriter
            file.close();


        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }


    ////////////////////////
    @Override
    public void csvtopdf() throws IOException, DocumentException {
        CSVReader reader = new CSVReader(new FileReader("/Users/azuga/Desktop/weather1.csv"));//reading csv file from given path
        String[] nextLine;
        Rectangle rc=new Rectangle(7000f,6500f);
        Document my_pdf_data = new Document(rc);
        PdfWriter.getInstance(my_pdf_data, new FileOutputStream("/Users/azuga/Desktop/converted_PDF_File.pdf"));//writing pdf file to given path
        my_pdf_data.open();
        PdfPTable my_first_table = new PdfPTable(42);


        PdfPCell table_cell;
        while ((nextLine = reader.readNext()) != null) {
            int i = 0;
            while (i < 42) {
                table_cell = new PdfPCell(new Phrase(nextLine[i]));
                my_first_table.addCell(table_cell);
                i++;
            }
        }


        my_pdf_data.add(my_first_table);
        my_pdf_data.close();
    }

    ///////////////////////
    @Override
    public void csvtohtml() {
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


    //////////////////

}
