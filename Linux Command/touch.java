/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -Adarsh (adarshs@azuga.com).
 */

package com.training.day1;

import java.io.*;

/**
 * This class mimics the touch command of linux
 */
public class touch {
    public static void main(String[] args) {
        try{
            File f = new File(args[0]);
            if(!f.exists() && f.createNewFile()){
                System.out.println("File created" + f.getName());
            }
            else{
                System.out.println("file already exists");
            }
        }
        catch(IOException e){
            System.out.println("error");
            e.printStackTrace();
        }
    }
}
