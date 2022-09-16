/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -Adarsh (adarshs@azuga.com).
 */

package com.training.day1;

/**
 * This class mimics the pwd command of linux
 */
public class pwd {
   public static void main(String[] argv) throws Exception {
      String currentDirectory = System.getProperty("user.dir");
      System.out.println("The current working directory is " + currentDirectory);
   }
}
