package com.p.v_0;

public class Demo {
    public static void main(String[] args) {
        Metrics metrics = new Metrics();
        UserController userController = new UserController(metrics);

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 10; i++) {
            userController.login("15078367322", "123456");
            userController.register(null);
        }
        System.out.println("r "+metrics.getResponseTimes());
        System.out.println("t "+metrics.getTimestamps());

    }
}
