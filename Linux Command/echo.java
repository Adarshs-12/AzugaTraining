/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -Adarsh (adarshs@azuga.com).
 */

package com.training.day1;
import java.util.*;

/**
 * This class mimics the echo commandof linux
 */
public class echo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data");
        String str = sc.nextLine();
        System.out.println("your data is :" + str);
    }
}
