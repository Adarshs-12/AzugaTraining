/*
 * Copyright (c) 2022.  - All Rights Reserved
 * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 * is strictly prohibited-
 * @Author -Adarsh (adarshs@azuga.com).
 */
package com.training.day4;

import com.training.day5.ConverterTest;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.core.config.plugins.convert.HexConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


/**
 * This test class checks the ans of the pipe program with the actual CLI ans
 */
public class pipeTest {

    pipe1 p = new pipe1();

    static final Logger log = Logger.getLogger(pipeTest.class);

    /**
     *Test method testCatHead checks the expected ans with actual ans
     */
    @Test
    void testCatHead(){
        log.info("Test to check the pipe program ans with CLI ans");
        String expected = "Maruti Suzuki\nHyundai Motors\nTata Motors\nToyota\nKia Motors\nSkoda\nMG\nMercedes\n";
        String actual = p.pipes("cat /Users/azuga/Desktop/cars.txt | head -8");
        Assertions.assertEquals(expected, actual);
    }

    /**
     *Test method testCatWC checks the expected ans with actual ans
     */
    @Test
    void testCatWc(){
        log.info("Test to check the pipe program ans with CLI ans");
        String expected = "19\t23\t150";
        String actual = p.pipes("cat /Users/azuga/Desktop/cars.txt | wc");
        Assertions.assertEquals(expected,actual);
    }

    /**
     *Test method testCatSortHead checks the expected ans with actual ans
     */
    @Test
    void testCatSortHead(){
        log.info("Test to check the pipe program ans with CLI ans");
        String expected = "Audi\nBMW\nDatsun\nFord\n";
        String actual = p.pipes("cat /Users/azuga/Desktop/cars.txt | sort | head -4");
        Assertions.assertEquals(expected,actual);
    }

    /**
     *Test method testCatUniqTail checks the expected ans with actual ans
     */
    @Test
    void testCatUniqTail(){
        log.info("Test to check the pipe program ans with CLI ans");
        String expected = "Ford\nNissan\nAudi\nDatsun\nTesla\n";
        String actual = p.pipes("cat /Users/azuga/Desktop/cars.txt | uniq | tail -5");
        Assertions.assertEquals(expected, actual);
    }

    /**
     *Test method testCatTail checks the expected ans with actual ans
     */
    @Test
    void testCatTail() {
        log.info("Test to check the pipe program ans with CLI ans");
        String expected = "Jeep\nFord\nNissan\nAudi\nDatsun\nTesla\n";
        String actual = p.pipes("cat /Users/azuga/Desktop/cars.txt | tail -6");
        Assertions.assertEquals(expected, actual);
    }

    /**
     *Test method testCatSortHeadWC checks the expected ans with actual ans
     */
    @Test
    void testCatSortHeadWc() {
        log.info("Test to check the pipe program ans with CLI ans");
        String expected = "4\t4\t21";
        String actual = p.pipes("cat /Users/azuga/Desktop/cars.txt | sort | head -4 | wc");
        Assertions.assertEquals(expected, actual);
    }

    /**
     *Test method testNullPath checks if we pass the nothing in the Argument
     */
    @Test
    void testNullPath(){
        log.info("Test to check what program returns when we enters null");
        String expected = null;
        String actual = p.pipes(null);
        Assertions.assertEquals(expected , actual);
    }

    /**
     *Test method testWrongFile checks if we pass the wrong file
     */
    @Test
    void testWrongFile(){
        log.info("Test to check what program returns when we enters the wrong File");
        String expected = "No such file or directory";
        String actual = p.pipes("cat /Users/azuga/Desktop/xyz.txt");
        Assertions.assertEquals(expected , actual);
    }

    /**
     *Test method testWrongArgument checks if we pass the wrong Argument
     */
    @Test
    void testWrongArgument(){
        log.info("Test to check what program returns when we enters wrong command");
        String expected = "command not found";
        String actual = p.pipes("xyz");
        Assertions.assertEquals(expected , actual);
    }


}