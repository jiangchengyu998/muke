package com.Observer.v3;

import com.Observer.v2.PromotionService;
import com.google.common.eventbus.Subscribe;

public class RegPromotionObserver {
    private PromotionService promotionService; // 依赖注入

    @Subscribe
    public void handleRegSuccess(Long userId) {
        promotionService.issueNewUserExperienceCash(userId);
    }
}
