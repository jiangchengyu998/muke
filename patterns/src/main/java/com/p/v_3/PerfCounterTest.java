package com.p.v_3;



import java.util.ArrayList;
import java.util.List;

public class PerfCounterTest {
    public static void main(String[] args) {

        ConsoleReporter consoleReporter = new ConsoleReporter();
        consoleReporter.startRepeatedReport(60, 60);

        List emailToAddresses = new ArrayList<>();
        emailToAddresses.add("jchengyu0829@163.com");
        EmailReporter emailReporter = new EmailReporter(emailToAddresses);
        emailReporter.startDailyReport();

        // 收集接口访问数据
        MetricsCollector collector = new MetricsCollector();
        collector.recordRequest(new RequestInfo("register", 123, 10234));
        collector.recordRequest(new RequestInfo("register", 223, 11234));
        collector.recordRequest(new RequestInfo("register", 323, 12334));
        collector.recordRequest(new RequestInfo("login", 23, 12434));
        collector.recordRequest(new RequestInfo("login", 1223, 14234));

        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}