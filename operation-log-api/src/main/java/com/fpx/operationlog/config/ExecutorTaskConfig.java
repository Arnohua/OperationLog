package com.fpx.operationlog.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author dinghua
 * @since 2019/9/9
 */
@Configuration
@EnableAsync
public class ExecutorTaskConfig implements AsyncConfigurer {

    private static Integer CORE_SIZE = Runtime.getRuntime().availableProcessors();

    private static Logger logger = LoggerFactory.getLogger(ExecutorTaskConfig.class);

        @Override
        public Executor getAsyncExecutor() {
            ThreadPoolTaskExecutor threadPool = new ThreadPoolTaskExecutor();
            threadPool.setCorePoolSize(1);
            threadPool.setMaxPoolSize(CORE_SIZE * 2 + 1);
            threadPool.setQueueCapacity(2000);
            threadPool.setKeepAliveSeconds(60);
            threadPool.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
            threadPool.setThreadNamePrefix("operation-log-server-");
            threadPool.initialize();
            return threadPool;
        }

        @Override
        public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
            return (throwable, method, objects) -> logger.error(
                    "exception handler :{}, method :{}, objects :{}",throwable,method,objects);
        }
}
