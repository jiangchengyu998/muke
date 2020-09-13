package com.Proxy.demo;

import java.util.Map;

public interface StatViewer {
    void output(Map<String, RequestStat> requestStats, long startTimeInMillis, long endTimeInMills);
}
