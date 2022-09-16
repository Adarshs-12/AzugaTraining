/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -Adarsh (adarshs@azuga.com).
 */

package com.training.day1;

import java.io.File;

/**
 * This class mimics the rmdir command of linux
 */
public class rmdir {
    public static void helper(String path){
        File f = new File(path);
        String[] temp = f.list();

        if(temp != null && temp.length > 0 ){
            System.out.println("Directory has more than one file");
        }
        else{
            if(f.delete()){
                System.out.println("Deleted sucessfully");
            }
        }
    }
    public static void main(String[] args) {
        
        helper(args[0]);
    }
}
