package com.Observer.v2;

public class RegPromotionObserver implements RegObserver {
    private PromotionService promotionService; // 依赖注入

    /**
     * 使用异步的方式
     * @param userId
     */
    @Override
    public void handleRegSuccess(long userId) {
        Thread thread = new Thread(() -> promotionService.issueNewUserExperienceCash(userId));
        thread.start();
    }
}
