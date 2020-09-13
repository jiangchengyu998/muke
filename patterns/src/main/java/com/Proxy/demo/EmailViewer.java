package com.Proxy.demo;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmailViewer implements StatViewer {
    private EmailSender emailSender;
    private List<String> toAddresses = new ArrayList<>();

    public EmailViewer() {
        this.emailSender = new EmailSender(/*省略参数*/);
    }



    public EmailViewer(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public EmailViewer(List emailToAddresses) {
        this.emailSender = new EmailSender();
        toAddresses.addAll(emailToAddresses);
    }

    public void addToAddress(String address) {
        toAddresses.add(address);
    }

    public void output(
            Map<String, RequestStat> stats, long startTimeInMillis, long endTimeInMills) {
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
}
