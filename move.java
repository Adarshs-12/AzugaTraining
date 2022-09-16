/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -Adarsh (adarshs@azuga.com).
 */

package com.training.day1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * This class mimics the mv command of linux
 */
public class move {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.print("enter source ");
      String source  =  sc.next();
     
      System.out.print("enter dest"); 
      String dest = sc.next();

      moveFile(source,dest);
   }
   private static void moveFile(String src, String dest ) {
      Path result = null;
      try {
         result = Files.move(Paths.get(src), Paths.get(dest));
      } catch (IOException e) {
         System.out.println("Exception while moving file: " + e.getMessage());
      }
      if(result != null) {
         System.out.println("File moved successfully.");
      }else{
         System.out.println("File movement failed.");
      }
   }
}
