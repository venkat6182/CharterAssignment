package com.Rewards.CustomerRewards.controller;

import com.Rewards.CustomerRewards.model.Response;
import com.Rewards.CustomerRewards.model.Transaction;
import com.Rewards.CustomerRewards.service.RewardCalculationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    static final Logger log = LoggerFactory.getLogger(CustomerController.class);
    @Autowired
    private Transaction transaction;

    @Autowired
    RewardCalculationService rewardCalculationService;
    @RequestMapping(value="/api/v1/health", method= RequestMethod.POST)
    public String health(){

        return "Reward-Calculator is up!";
    }

    @RequestMapping(value="/api/v1/reward-calculator", method= RequestMethod.POST,consumes="application/json",produces="application/json")
    @ResponseBody
    public List<Response> rewardCalculator(@RequestBody List<Transaction> transactionList) {
        log.info("Starting of Rest end point for rewardCalculator");
        List<Response> response =  rewardCalculationService.customerRewardsPoints(transactionList);
        log.info("end of Rest end point for rewardCalculator");
        return response;
    }
}
