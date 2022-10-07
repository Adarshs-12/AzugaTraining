/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -Adarsh (adarshs@azuga.com).
 */

package com.training.day1;
import java.io.File;

/**
 * This class mimics the mkdir command of linux
 */
public class Mkdir {
    public static void  helper(String path){
        File f = new File(path);
        if(f.mkdir()){
            System.out.println("File created successfully");
        }
        else{
            System.out.println("Not created");
        }
    }
    public static void main(String[] args) {
        helper(args[0]);
    }
}
