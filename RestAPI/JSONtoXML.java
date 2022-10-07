/*
 * Copyright (c) 2022.  - All Rights Reserved
 *  * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 *  * is strictly prohibited-
 *  * @Author -Adarsh
 */

package com.training.day5;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Node;
import org.w3c.dom.bootstrap.DOMImplementationRegistry;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONtoXML {
    public static void main(String[] args) throws JSONException {
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
                    sb.append(convertToXML(arr[i] + "}", "root"));// This method converts json object to xml string
                }
                else if (i==arr.length-1) {
//                    System.out.println(arr[i].charAt(arr[i].length()-1));
                    result="{"+arr[i];
                    sb.append(convertToXML(result, "root"));//file.append(convertToXML(arr[i], "root"));
//                    System.out.println("hey!!!");
                }
                else{
                    System.out.println(i);
                    result="{"+arr[i]+"}";
                    sb.append(convertToXML(result, "root"));

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

    public static String format(String xml) {

        try {
            final InputSource src = new InputSource(new StringReader(xml));
            final Node document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(src).getDocumentElement();
            final Boolean keepDeclaration = xml.startsWith("<?xml");

            //May need this: System.setProperty(DOMImplementationRegistry.PROPERTY,"com.sun.org.apache.xerces.internal.dom.DOMImplementationSourceImpl");


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
     * @param jsonString-json string as input
     * @param root -root element for xml
     * @return - returns xml as a string
     * @throws JSONException - to handle syntax error of json string
     */
    public static String convertToXML(String jsonString, String root) throws JSONException {    // handle JSONException
        JSONObject jsonObject =new JSONObject(jsonString);
        String unformattedXml =  "<"+root+">" + XML.toString(jsonObject) + "</"+root+">";
        return format(unformattedXml);
    }
}
