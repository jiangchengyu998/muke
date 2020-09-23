package com.Observer.v2;


import com.Observer.EventBus.Subscribe;

public class RegNotificationObserver implements RegObserver {
    private NotificationService notificationService;

    @Subscribe
    @Override
    public void handleRegSuccess(Long userId) {
        notificationService.sendInboxMessage(userId, "Welcome...");
    }
}
