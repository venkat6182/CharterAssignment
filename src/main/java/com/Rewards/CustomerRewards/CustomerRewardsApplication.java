package com.Rewards.CustomerRewards;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class CustomerRewardsApplication {
    static final Logger log = LoggerFactory.getLogger(CustomerRewardsApplication.class);

    public static void main(String[] args) {
        log.info("Before Starting Application");
        SpringApplication.run(CustomerRewardsApplication.class, args);
        log.info(" Starting My Application with {} arguments.", args.length);

    }

}
