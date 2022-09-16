/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -Adarsh (adarshs@azuga.com).
 */

package com.training.day1;
import java.io.*;

/**
 * This class mimics the copy command of linux
 */
public class copy {
    public static void main(String[] args) throws IOException {
        FileInputStream f = new FileInputStream(args[0]);      //used to read data (in bytes) from files
        FileOutputStream n = new FileOutputStream(args[1]);    //used to write data (in bytes) to the files.
        int i;
        while((i = f.read()) != -1){
            n.write((char)i);
        }

    }
}
