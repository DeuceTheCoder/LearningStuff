package com.playingAround;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("spring-config.xml");
        Office office = context.getBean("office", com.playingAround.Office.class);
        office.workOnASundayAfternoon();
    }
}
