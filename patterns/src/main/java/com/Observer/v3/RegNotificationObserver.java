package com.Observer.v3;


import com.Observer.v2.NotificationService;
import com.google.common.eventbus.Subscribe;

public class RegNotificationObserver {
    private NotificationService notificationService;

    @Subscribe
    public void handleRegSuccess(Long userId) {
        notificationService.sendInboxMessage(userId, "...");
    }
}

