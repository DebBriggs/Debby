package com.debby.debby;

import java.util.LinkedHashMap;

public class Profiles {

    static LinkedHashMap<String, String> l;

    public final static String name= "Name:";
    public final static String track ="Track:";
    public final static String country = "Country:";
    public final static String email = "Email:";
    public final static String phone_no = "Phone Number:";
    public final static String slackname = "Slack Username:";

    public static void Profile_1()
    {

    }

    public static LinkedHashMap<String, String> Ruth()
    {
        l=new LinkedHashMap<>();
        l.put(track , "Android");
        l.put(country, "Nigeria");
        l.put(email,"briggsruthjoy@gmail.com");
        l.put(phone_no,"2348120223876");
        l.put(slackname,"BriggsRuth");
        return l;
    }

    public static  LinkedHashMap<String, String> Debby()
    {
        l=new LinkedHashMap<>();
        l.put(track , "Android");
        l.put(country, "Nigeria");
        l.put(email,"briggsdeborahokorite@gmail.com");
        l.put(phone_no,"2349091857784");
        l.put(slackname,"briggs_deborah");
        return l;
    }
}
