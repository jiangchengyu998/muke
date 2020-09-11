package com.p.v_3;


import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import com.google.common.eventbus.Subscribe;
import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Executors;

public class MetricsCollector {

    private static final int DEFAULT_STORAGE_THREAD_POOL_SIZE = 20;

    private MetricsStorage metricsStorage;//基于接口而非实现编程
    private EventBus eventBus;

    public MetricsCollector() {
        this(new RedisMetricsStorage(), DEFAULT_STORAGE_THREAD_POOL_SIZE);
    }

    public MetricsCollector(MetricsStorage metricsStorage, int threadNumToSaveData) {
        this.metricsStorage = metricsStorage;
        this.eventBus = new AsyncEventBus(Executors.newFixedThreadPool(threadNumToSaveData));
        this.eventBus.register(new EventListener());
    }

    //依赖注入
    public MetricsCollector(MetricsStorage metricsStorage) {
        this(metricsStorage, DEFAULT_STORAGE_THREAD_POOL_SIZE);
    }

    //用一个函数代替了最小原型中的两个函数
    public void recordRequest(RequestInfo requestInfo) {
        if (requestInfo == null || StringUtils.isBlank(requestInfo.getApiName())) {
            return;
        }
        eventBus.post(requestInfo);
    }

    public class EventListener {
        @Subscribe
        public void saveRequestInfo(RequestInfo requestInfo) {
            metricsStorage.saveRequestInfo(requestInfo);
        }
    }
}

