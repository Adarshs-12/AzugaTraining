/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -Adarsh (adarshs@azuga.com).
 */
package com.training.day2;
import java.util.*;
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;
import java.util.Date;

/**
 * This class mimics ls command of linux
 */
public class ls {
    /**
     *This method is used to print all the files that are present in our current diractory in each line
     */
    public static void ls1(){
        File f = new File(System.getProperty("user.dir"));
        String[] newArr = f.list();
        if(newArr != null){
            Arrays.sort(newArr);
            for(String i : newArr){
                if (i.charAt(0)!='.'){
                    System.out.println(i);
                }
            }
        }
    }

    /**
     *This method is used to print all the files that are in our current directory the file in reverse order
     */
    public static void lsr(){
        File f = new File(System.getProperty("user.dir"));
        String[] newArr = f.list();
        if(newArr != null){
            Arrays.sort(newArr);
            int i=newArr.length-1;
            while (i>=0){
                if (newArr[i].charAt(0)!='.'){
                    System.out.printf(newArr[i]+"\t");
                }
                i=i-1;
            }
        }
    }

    /**
     *This method is used to print all the files that are in our current directory in sorted order
     */
    public static void lsx(){
        File f = new File(System.getProperty("user.dir"));
        String[] newArr = f.list();
        if(newArr != null){
            Arrays.sort(newArr);
            for(String i : newArr){
                if (i.charAt(0)!='.'){
                    System.out.printf(i+"\t");
                }
            }
        }
    }

    /**
     *This method is used to print the files that are in our current directory including the hidden files.
     */
    public static void lsa(){
        File f = new File(System.getProperty("user.dir"));
        String[] newArr = f.list();
        if(newArr != null){
            Arrays.sort(newArr);
            for(String i : newArr){
                System.out.printf(i+"\t");
            }
        }
    }

    /**
     *This method is used to enlist the long listing of whole files that are in our current directory including the
     * hidden files.
     */
    public static void lsla(){
        File f = new File(System.getProperty("user.dir"));
        File[] array = f.listFiles();
        if(array != null){
            try {
                for (File f1 : array) {
                    Path p = Path.of(f1.getPath());
                    PosixFileAttributes ats = Files.readAttributes(p, PosixFileAttributes.class);
                    System.out.print(PosixFilePermissions.toString(ats.permissions()) + " ");
                    System.out.print(ats.owner().getName() + "   ");
                    System.out.print(ats.group().getName() + "   ");
                    System.out.print(ats.size() / 1024 + "kb   ");
                    System.out.print(new Date(f1.lastModified()) + "   ");
                    System.out.print(f1.getName());
                    System.out.println();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     *This method is used to print all the files that are in our directory in long listing form
     */
    public static void lsl(){
        File f = new File(System.getProperty("user.dir"));
        File[] array = f.listFiles();
        if(array != null){
            try {
                for (File f1 : array) {
                    if (!f1.isHidden()){
                        Path p = Path.of(f1.getPath());
                        PosixFileAttributes ats = Files.readAttributes(p, PosixFileAttributes.class);
                        System.out.print(PosixFilePermissions.toString(ats.permissions()) + " ");
                        System.out.print(ats.owner().getName() + "   ");
                        System.out.print(ats.group().getName() + "   ");
                        System.out.print(ats.size() / 1024 + "kb   ");
                        System.out.print(new Date(f1.lastModified()) + "   ");
                        System.out.print(f1.getName());
                        System.out.println();
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * This method is used to print all files that are in our current working directory excluding hidden files
     */
    public static void lsm() {
        File f = new File(System.getProperty("user.dir"));
        String[] newArr = f.list();
        if (newArr != null) {
            for (String i : newArr){
                if (i.charAt(0) != '.') {
                    System.out.print(i + ", ");
                }
            }
        }
    }

    /**
     * @param args - it is used to take the input from the user as command line argument
     */
    public static void main(String[] args) {
       // String s = args[0];
        switch (args[0]) {
            case "-a":
                lsa();
                break;
            case "-x":
                lsx();
                break;
            case "-r":
                lsr();
                break;
            case "-1":
                ls1();
                break;
            case "-m":
                lsm();
                break;
            case "-la":
                lsla();
                break;
            case "-l":
                lsl();
                break;
            default:
                System.out.println("Enter correct ls command");
        }
    }
}