package com.bottomline.com.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MyLogger {

    private static Logger logger;

    public static void init(){
        logger = LogManager.getLogger("Amazon tests Automation");
    }

    public static Logger getLogger(){
        return logger;
    }
}
