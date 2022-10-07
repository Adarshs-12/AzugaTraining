/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -Adarsh (adarshs@azuga.com).
 */
package com.training.day4;
import java.io.*;
import java.nio.file.*;
import java.util.*;

/**
 * This class mimics the pipe command of linux
 */
public class pipe1 {


    public static String cat(String path) throws IOException {
        return Files.readString(Path.of(path));
    }
    public static void sort(String str) {
        String[] lines = str.split("\n\r|\r|\n");
        List<String> ls = new ArrayList<>();
        Collections.addAll(ls, lines);
        Collections.sort(ls);

        for (String e : ls) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws IOException {
          
            String str = args[0];
	    String[] s = str.split(" ");
	    if (s[0].equals("cat") && s.length <= 3) {
			System.out.println(cat(s[1]));
            }
             else if (s.length >= 3) {
			if (s[0].equals("cat") && s[2].equals("|") && s[3].equals("sort")) {
				sort(cat(s[1]));
                        }
	     }			
       
    }

}
