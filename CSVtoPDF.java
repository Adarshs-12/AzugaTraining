package com.training.day5;

import au.com.bytecode.opencsv.CSVReader;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

/**
 * This class converts the csv file to pdf file
 */
public class CSVtoPDF {
    public static void main(String[] args) throws IOException, DocumentException {
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
}