package com.Rewards.CustomerRewards.service;

import com.Rewards.CustomerRewards.common.CommonConstant;
import com.Rewards.CustomerRewards.model.MonthlyReponseMessage;
import com.Rewards.CustomerRewards.model.Response;
import com.Rewards.CustomerRewards.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;

@Service
public class RewardCalculationService {

    static final Logger log = LoggerFactory.getLogger(RewardCalculationService.class);
    private Set<String> transactionMonths = new HashSet<>();
   // In this method mapping all transcation made by single customer
    public Map<String, List<Transaction>> mapAllUniqueCustomerID(List<Transaction> transactionList) {
        log.info(" Starting method to getALLAllUniqueCustomerID");
        Map<String, List<Transaction>> uniqueCustomerIDMap = new HashMap<>();
        Set<String> uniqueCustomerID = new HashSet<>();
        for (Transaction transaction : transactionList) {
            uniqueCustomerID.add(transaction.getCustomerId());
            transactionMonths.add(transaction.getMonth());
        }
        for (String customerId : uniqueCustomerID) {
            ArrayList<Transaction> singleCustomerTransaction = new ArrayList<>();
            for (Transaction transaction : transactionList) {
                if (customerId.equalsIgnoreCase(transaction.getCustomerId())) {
                    singleCustomerTransaction.add(transaction);
                }
            }
            uniqueCustomerIDMap.put(customerId, singleCustomerTransaction);
        }
        log.info(" end of method to getALLAllUniqueCustomerID");
        return uniqueCustomerIDMap;
    }
  //calculate total rewards, monthly rewards and preaparing response
    public List<Response> customerRewardsPoints(List<Transaction> transactionList) {
        log.info(" Starting method to customerRewardsPoints");
        Map<String, List<Transaction>> customerMap = mapAllUniqueCustomerID(transactionList);

        List<String> listofmonths = new ArrayList<>(transactionMonths);
        sortmonths(listofmonths);
        Map<String, MonthlyReponseMessage> responsBody = new HashMap<>();
        List<Response> responseBodies = new ArrayList<>();

        for (Map.Entry<String, List<Transaction>> customerTransactions : customerMap.entrySet()) {
            int[] rewards = new int[4];
            ArrayList<Integer> firstMonthPrice = new ArrayList<>();
            ArrayList<Integer> seconMonthPrice = new ArrayList<>();
            ArrayList<Integer> thirdMonthPrice = new ArrayList<>();
            ArrayList<Integer> totalMonthPrice = new ArrayList<>();

            MonthlyReponseMessage monthlyReponseMessage = new MonthlyReponseMessage();
            Response response = new Response();
            for (Transaction transaction : customerTransactions.getValue()) {

                if (transaction.getMonth().equalsIgnoreCase(listofmonths.get(0))) {
                    rewards[0] = rewards[0] + calculateRewardPoints(transaction.getPrice());
                    firstMonthPrice.add(transaction.getPrice());
                } else if (transaction.getMonth().equalsIgnoreCase(listofmonths.get(1))) {
                    rewards[1] = rewards[1] + calculateRewardPoints(transaction.getPrice());
                    seconMonthPrice.add(transaction.getPrice());
                } else if (transaction.getMonth().equalsIgnoreCase(listofmonths.get(2))) {
                    rewards[2] = rewards[2] + calculateRewardPoints(transaction.getPrice());
                    thirdMonthPrice.add(transaction.getPrice());
                }
                rewards[3] = rewards[3] + calculateRewardPoints(transaction.getPrice());
                totalMonthPrice.add(transaction.getPrice());
            }

            monthlyReponseMessage.setFirstMonthRewards(rewards[0]);
            monthlyReponseMessage.setFirstMonthPrices(firstMonthPrice);
            monthlyReponseMessage.setSecondMonthRewards(rewards[1]);
            monthlyReponseMessage.setSecondMonthPrices(seconMonthPrice);
            monthlyReponseMessage.setThirdMonthRewards(rewards[2]);
            monthlyReponseMessage.setThirdMonthPrices(thirdMonthPrice);

            response.setCustomerId(customerTransactions.getKey());
            response.setTotalPrices(totalMonthPrice);
            response.setTotalRewards(rewards[3]);
            response.setMonthlyReponseMessage(monthlyReponseMessage);
            responseBodies.add(response);
        }
        log.info(" End of method to customerRewardsPoints");

        return responseBodies;
    }
    // Sorting months jan to dec order
    public Integer calculateRewardPoints(Integer transactionPrice) {
        log.info(" Starting method to calculateRewardPoints");
        int rewards = 0;
        if (transactionPrice > CommonConstant.HUNDRED) {
            rewards = (transactionPrice - CommonConstant.HUNDRED) * CommonConstant.TWO + CommonConstant.FIFTEY;
        } else if (transactionPrice <= CommonConstant.HUNDRED && transactionPrice > CommonConstant.FIFTEY) {
            rewards = transactionPrice - CommonConstant.FIFTEY;
        }
        log.info(" End of method to calculateRewardPoints");
        return rewards;
    }

    public List<String> sortmonths(List<String> months) {
        log.info(" Starting method to sortmonths");
        final Comparator<String> dateCompare = new Comparator<String>() {

            public int compare(String o1, String o2) {

                SimpleDateFormat s = new SimpleDateFormat("MMM");
                Date s1 = null;
                Date s2 = null;
                try {
                    s1 = s.parse(o1);
                    s2 = s.parse(o2);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return s1.compareTo(s2);
            }
        };

        Collections.sort(months, dateCompare);
        log.info(" End of method to sortmonths");
        return months;
    }


}
