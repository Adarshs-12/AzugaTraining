/*
 * Copyright (c) 2022.  - All Rights Reserved
 *  * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 *  * is strictly prohibited-
 *  * @Author - Adarsh.
 */

package com.training.day5;
import java.io.FileOutputStream;
import java.io.*;
import au.com.bytecode.opencsv.CSVReader;
import java.io.FileReader;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
public class CSVtoPDF {
    public static void main(String[] args) throws IOException, DocumentException {

        String CSVFile = "/Users/azuga/Desktop/weather1.csv";        //Read input CSV file in Java
        CSVReader reader = new CSVReader(new FileReader(CSVFile));
        /* Variables to loop through the CSV File */
        String [] nextLine; /* for every line in the file */
        int lineNumber = 0; /* line number */
        /* Step-2: Initialize PDF documents - logical objects */
        Document my_pdf_data = new Document();
        PdfWriter.getInstance(my_pdf_data, new FileOutputStream("/Users/azuga/Desktop/converted_PDF_File.pdf"));
        my_pdf_data.open();
        PdfPTable my_first_table = new PdfPTable(15);
        PdfPCell table_cell;
        /* Step -3: Loop through CSV file and populate data to PDF table */
        while ((nextLine = reader.readNext()) != null) {
            lineNumber++;
            int i=0;
            while(i<=42) {
                table_cell = new PdfPCell(new Phrase(nextLine[i]));
                my_first_table.addCell(table_cell);
                i++;
            }
        }
        /* Step -4: Attach table to PDF and close the document */
        my_pdf_data.add(my_first_table);
        my_pdf_data.close();
    }
}