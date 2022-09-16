/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -Adarsh (adarshs@azuga.com).
 */

package com.training.day1;

import java.nio.file.*;

/**
 * This class mimics the whoami command of linux
 */
public class Whoami {
    public static void main(String[] args)throws Exception{

        System.out.println(Files.getOwner(Path.of(System.getProperty("user.dir"))));
    }
}