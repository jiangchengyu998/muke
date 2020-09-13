package com.Proxy.demo;

import com.google.gson.Gson;

import java.util.Map;

public class ConsoleViewer implements StatViewer {
    @Override
    public void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills) {
        System.out.println("Time Span: [" + startTimeInMillis + ", " + endTimeInMills + "]");
        Gson gson = new Gson();
        try {
            System.out.println(gson.toJson(requestStats));
        } catch (Exception e) {
            System.err.println("出错了");
            e.printStackTrace();
        }
    }
}
