package com.fpx.operationlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author dinghua
 * @date 2019/9/9
 * @since v1.0.0
 */
@SpringBootApplication
@EnableAutoConfiguration
public class OperationLogStarter {

    public static void main(String[] args){
        SpringApplication.run(OperationLogStarter.class,args);
    }
}
