/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -Adarsh (adarshs@azuga.com).
 */

package com.training.day1;

import java.io.File;

/**
 * This class mimics the rm command of linux
 */
public class remove {
    public static void recurDelete(File f){

        if(!f.exists()){
            return;
        }
        if(f.isDirectory()){
            File[] array = f.listFiles();
            if(array != null){
                for(File t : array){
                    recurDelete(t);
                }
            }

        }
        f.delete();
    }
    public static void main(String[] args) {
        File f = new File(args[0]);
        recurDelete(f);
    }
}

