/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -Adarsh (adarshs@azuga.com).
 */

package com.training.day1;
import java.io.*;

/**
 * This class mimics the cat command of linux
 */
public class cat {

    public static void main(String[] args) throws Exception{
        FileReader f = new FileReader(args[0]);           //Read the content of file
        BufferedReader br = new BufferedReader(f);        //Reads text from file
        String buffer;
        
        while ((buffer = br.readLine()) != null) {
            System.out.println(buffer);
            
        }
        br.close();
        f.close();
    }
}

