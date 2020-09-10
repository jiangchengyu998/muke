package com.p.v_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Aggregator {
    public Map<String, RequestStat> aggregate(
            Map<String, List<RequestInfo>> requestInfos, long durationInMillis) {
        Map<String, RequestStat> requestStats = new HashMap<>();
        for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
            String apiName = entry.getKey();
            List<RequestInfo> requestInfosPerApi = entry.getValue();
            RequestStat requestStat = doAggregate(requestInfosPerApi, durationInMillis);
            requestStats.put(apiName, requestStat);
        }
        return requestStats;
    }

    private RequestStat doAggregate(List<RequestInfo> requestInfos, long durationInMillis) {
        List<Double> respTimes = new ArrayList<>();
        for (RequestInfo requestInfo : requestInfos) {
            double respTime = requestInfo.getResponseTime();
            respTimes.add(respTime);
        }

        RequestStat requestStat = new RequestStat();
        requestStat.setMaxResponseTime(max(respTimes));
        requestStat.setMinResponseTime(min(respTimes));
        requestStat.setAvgResponseTime(avg(respTimes));
        requestStat.setP999ResponseTime(percentile999(respTimes));
        requestStat.setP99ResponseTime(percentile99(respTimes));
        requestStat.setCount(respTimes.size());
        requestStat.setTps((long) tps(respTimes.size(), durationInMillis/1000));
        return requestStat;
    }

    // 以下的函数的代码实现均省略...
    private double max(List<Double> dataset) {

        double maxRespTime = Double.MIN_VALUE;
        for (Double aDouble : dataset) {
            if (maxRespTime < aDouble) {
                maxRespTime = aDouble;
            }
        }
        return maxRespTime;
    }

    private double min(List<Double> dataset) {
        double minRespTime = Double.MAX_VALUE;
        for (Double aDouble : dataset) {
            if (minRespTime > aDouble) {
                minRespTime = aDouble;
            }
        }
        return minRespTime;
    }
    private double avg(List<Double> dataset) {
        double sumRespTime = 0;
        long count = 0;
        for (Double aDouble : dataset) {
            ++count;
            sumRespTime += aDouble;
        }
        if (count > 0) {
            return sumRespTime / count;
        }
        return 0d;
    }
    private double tps(int count, double duration) {
        return 1d;
    }
    private double percentile999(List<Double> dataset) {
        return 1d;
    }
    private double percentile99(List<Double> dataset) {
        return 1d;
    }
    private double percentile(List<Double> dataset, double ratio) {
        return 1d;
    }
}