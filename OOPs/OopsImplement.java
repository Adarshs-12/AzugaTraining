/*
        * Copyright (c) 2022.  - All Rights Reserved
        * Unauthorized copying or redistribution of this file in source and binary forms via any medium
        * is strictly prohibited-
        * @Author -Adarsh (adarshs@azuga.com).
 */
package com.training.day5;

import com.itextpdf.text.DocumentException;

import java.io.IOException;

public class OopsImplement {
    public static void main(String[] args) throws DocumentException, IOException {
        OopsClass obj = new OopsClass();
        obj.csvtohtml();
        obj.csvtopdf();
        obj.jsontoxml();
    }
}
