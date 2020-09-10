package com.p.v_1;

import com.google.gson.Gson;
import com.p.mailUtil.EmailSender;

import java.text.DateFormat;
import java.util.*;

public class EmailReporter {
    private static final Long DAY_HOURS_IN_SECONDS = 86400L;

    private MetricsStorage metricsStorage;
    private EmailSender emailSender;
    private List<String> toAddresses = new ArrayList<>();

    public EmailReporter(MetricsStorage metricsStorage) {
        this(metricsStorage, new EmailSender(/*省略参数*/));
    }

    public EmailReporter(MetricsStorage metricsStorage, EmailSender emailSender) {
        this.metricsStorage = metricsStorage;
        this.emailSender = emailSender;
    }

    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    public void startDailyReport() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date firstTime = calendar.getTime();
        DateFormat dateInstance = DateFormat.getDateTimeInstance();
        Date date = new Date();
        System.out.println("第一次日期" + dateInstance.format(firstTime));
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                long durationInMillis = DAY_HOURS_IN_SECONDS * 1000;
                long endTimeInMillis = System.currentTimeMillis();
                long startTimeInMillis = endTimeInMillis - durationInMillis;
                Map<String, List<RequestInfo>> requestInfos =
                        metricsStorage.getRequestInfos(startTimeInMillis, endTimeInMillis);
                Map<String, RequestStat> stats = new HashMap<>();
                for (Map.Entry<String, List<RequestInfo>> entry : requestInfos.entrySet()) {
                    String apiName = entry.getKey();
                    List<RequestInfo> requestInfosPerApi = entry.getValue();
                    RequestStat requestStat = Aggregator.aggregate(requestInfosPerApi, durationInMillis);
                    stats.put(apiName, requestStat);
                }
                Gson gson = new Gson();
                System.out.println("发送邮件");
                try {
                    String login = String.format("<!DOCTYPE html>\n" +
                                    "<html lang=\"en\" xmlns=\"http://www.w3.org/1999/html\">\n" +
                                    "<head>\n" +
                                    "    <meta charset=\"UTF-8\">\n" +
                                    "    <title>性能监控</title>\n" +
                                    "</head>\n" +
                                    "<body>\n" +
                                    "<p style=\"text-align: left;\">\n" +
                                    "    <strong>login接口</strong>：<br style=\"text-align: left;\"/>\n" +
                                    "    <span style=\"background-color: rgb(255, 0, 0);\">最大值</span>：%s；<br style=\"text-align: left;\"/>\n" +
                                    "    <span style=\"background-color: rgb(0, 176, 80);\">最小值</span>：%s；<br style=\"text-align: left;\"/>\n" +
                                    "    <span style=\"background-color: rgb(155, 187, 89);\">平均值</span>：%s；<br style=\"text-align: left;\"/>\n" +
                                    "    <span style=\"background-color: rgb(255, 255, 0);\">p999ResponseTime值</span>：%s；<br style=\"text-align: left;\"/>\n" +
                                    "    <span style=\"background-color: rgb(0, 176, 240);\">p99ResponseTime值</span>：%s；<br style=\"text-align: left;\"/>\n" +
                                    "    <span style=\"background-color: rgb(112, 48, 160);\">数量</span>：%s；<br style=\"text-align: left;\"/>\n" +
                                    "    <span style=\"background-color: rgb(255, 192, 0);\">tps</span>：%s；<br style=\"text-align: left;\"/>\n" +
                                    "    <strong>register接口</strong>：<br style=\"text-align: left;\"/>\n" +
                                    "    <span style=\"background-color: rgb(255, 0, 0);\">最大值</span>：%s；<br style=\"text-align: left;\"/>\n" +
                                    "    <span style=\"background-color: rgb(0, 176, 80);\">最小值</span>：%s；<br style=\"text-align: left;\"/>\n" +
                                    "    <span style=\"background-color: rgb(155, 187, 89);\">平均值</span>：%s；<br style=\"text-align: left;\"/>\n" +
                                    "    <span style=\"background-color: rgb(255, 255, 0);\">p999ResponseTime值</span>：%s；<br style=\"text-align: left;\"/>\n" +
                                    "    <span style=\"background-color: rgb(0, 176, 240);\">p99ResponseTime值</span>：%s；<br style=\"text-align: left;\"/>\n" +
                                    "    <span style=\"background-color: rgb(112, 48, 160);\">数量</span>：%s；<br style=\"text-align: left;\"/>tps：%s；\n" +
                                    "</p>\n" +
                                    "<p>\n" +
                                    "    <br style=\"white-space: normal; text-align: left;\"/>\n" +
                                    "</p>\n" +
                                    "</body>\n" +
                                    "</html>",
                            stats.get("login").getMaxResponseTime(),
                            stats.get("login").getMinResponseTime(),
                            stats.get("login").getAvgResponseTime(),
                            stats.get("login").getP999ResponseTime(),
                            stats.get("login").getP99ResponseTime(),
                            stats.get("login").getCount(),
                            stats.get("login").getTps(),
                            stats.get("register").getMaxResponseTime(),
                            stats.get("register").getMinResponseTime(),
                            stats.get("register").getAvgResponseTime(),
                            stats.get("register").getP999ResponseTime(),
                            stats.get("register").getP99ResponseTime(),
                            stats.get("register").getCount(),
                            stats.get("register").getTps());

                    emailSender.sender(toAddresses.get(0), "监控数据", login);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }, date, 1 * 1000 * 20);
    }
}

