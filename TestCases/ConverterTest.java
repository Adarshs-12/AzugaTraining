/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -Adarsh (adarshs@azuga.com).
 */
package com.training.day5;

import com.itextpdf.text.DocumentException;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This test class checks the content of the HTML , PDF and XML files
 */
public class ConverterTest {

    static final Logger log = Logger.getLogger(ConverterTest.class);

    /**
     * Test method testCsvToHtml checks the content of the expected and actual file
     */
    @Test
    void testCsvToHtml(){
        log.info("Test to check the content of the HTML file");
        try{
            CSVtoHTML obj1 = new CSVtoHTML();
            obj1.csvtohtml("/Users/azuga/Desktop/weather1.csv" , "/Users/azuga/Desktop/programCreatedHTML.html");
            assertTrue((new File("/Users/azuga/Desktop/weather1.csv")).exists());
            assertTrue((new File("/Users/azuga/Desktop/programCreatedHTML.html")).exists());
            byte[] expected=Files.readAllBytes(Paths.get("/Users/azuga/Desktop/weather1..html"));
            byte[] actual=Files.readAllBytes(Paths.get("/Users/azuga/Desktop/programCreatedHTML.html"));
            assertArrayEquals(actual,expected);
        }
        catch (IOException e){
            log.error("IOException : " + e);
        }
    }


    /**
     *Test method testJsonToXml checks the content of the expected and actual file
     */
    @Test
    void testJsonToXml (){
        log.info("Test to check the content of the XML file");
        try{
            JSONtoXML obj3 = new JSONtoXML();
            String expected = Files.readString(Path.of("/Users/azuga/Desktop/weatherxml.xml"));
            String actual = Files.readString(Path.of("/Users/azuga/Desktop/truth/check.xml"));
            assertEquals(expected, actual);
        }
        catch(IOException e){
            log.error("IOException : " + e);
        }
    }


    /**
     *Test method testCsvToPdf checks the content of expected and actual file
     */
    @Test
    void testCsvToPdf() {
        log.info("Test to check the content of Pdf file");
        try{
            CSVtoPDF obj2 = new CSVtoPDF();
            obj2.csvtopdf("/Users/azuga/Desktop/weather1.csv" , "/Users/azuga/Desktop/converted_PDF_File.pdf");
            assertTrue((new File("/Users/azuga/Desktop/weather1.csv")).exists());
            assertTrue((new File("/Users/azuga/Desktop/converted_PDF_File.pdf")).exists());
            String expected = Files.readString(Path.of("/Users/azuga/Desktop/converted_PDF_File.pdf"));
            String actual = Files.readString(Path.of("/Users/azuga/Desktop/truth/check.pdf"));
            Assertions.assertEquals(expected , actual);
        }
        catch(IOException e){
            log.error("IOException : " + e);
        }
        catch(DocumentException d){
            log.error("Documentation Exception : " + d);
        }
    }


    @Test
    void pdfDocumentException(){
        CSVtoPDF obj2 = new CSVtoPDF();
         assertThrows(NullPointerException.class,() ->
                obj2.csvtopdf("/Users/azuga/Desktop/weather1.csv" , null));
    }

    @Test
    void pdfIOException(){
        CSVtoPDF obj2 = new CSVtoPDF();
        Throwable exception = assertThrows(IOException.class,() ->
                obj2.csvtopdf("/Users/azuga/Desktop/xyz.csv" , "/Users/azuga/Desktop/converted_PDF_File.pdf"));
    }

}



