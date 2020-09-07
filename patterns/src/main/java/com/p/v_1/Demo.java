package com.p.v_1;


import redis.clients.jedis.Jedis;

public class Demo {
    public static void main(String[] args) {
        MetricsStorage storage = new RedisMetricsStorage(new Jedis("localhost", 6379));
        ConsoleReporter consoleReporter = new ConsoleReporter(storage);
        consoleReporter.startRepeatedReport(10, 10);

//        EmailReporter emailReporter = new EmailReporter(storage);
//        emailReporter.addToAddress("wangzheng@xzg.com");
//        emailReporter.startDailyReport();

        MetricsCollector collector = new MetricsCollector(storage);
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("register", 323, 12334));
        collector.recordRequest(new RequestInfo("login", 23, 12434));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));
        collector.recordRequest(new RequestInfo("login", 1210, 1210));
        collector.recordRequest(new RequestInfo("login", 1211, 14211));
        collector.recordRequest(new RequestInfo("login", 1212, 14212));
        collector.recordRequest(new RequestInfo("login", 1223, 14213));
        collector.recordRequest(new RequestInfo("login", 1223, 14214));
        collector.recordRequest(new RequestInfo("login", 1223, 14215));
        collector.recordRequest(new RequestInfo("login", 1223, 14216));
        collector.recordRequest(new RequestInfo("login", 1223, 14217));
        collector.recordRequest(new RequestInfo("login", 1223, 14218));
        collector.recordRequest(new RequestInfo("login", 1223, 14219));
        collector.recordRequest(new RequestInfo("login", 1223, 14220));
        collector.recordRequest(new RequestInfo("login", 1223, 14221));
        collector.recordRequest(new RequestInfo("login", 1223, 14222));
        collector.recordRequest(new RequestInfo("login", 1223, 14223));
        collector.recordRequest(new RequestInfo("login", 1223, 14224));
        collector.recordRequest(new RequestInfo("login", 1223, 14225));
        collector.recordRequest(new RequestInfo("login", 1223, 14226));
        collector.recordRequest(new RequestInfo("login", 1223, 14227));
        collector.recordRequest(new RequestInfo("login", 1223, 14228));
        collector.recordRequest(new RequestInfo("login", 1223, 14229));
        collector.recordRequest(new RequestInfo("login", 1223, 14230));

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
