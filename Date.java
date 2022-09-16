/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -Adarsh (adarshs@azuga.com).
 */

package com.training.day1;

import java.text.SimpleDateFormat;

/**
 * This class mimics the Date command of linux
 */
public class Date {
    public static void main(String[] args){
        Long d = System.currentTimeMillis();
        SimpleDateFormat formatter = new SimpleDateFormat("E, dd MMM yyyy HH:mm:ss z");

        System.out.println(formatter.format(d));
    }
}
