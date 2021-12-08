package com.Rewards.CustomerRewards.model;

import java.util.List;

public class Response {
    private String customerId;
    private List<Integer> totalPrices;
    private Integer totalRewards;
    private MonthlyReponseMessage monthlyReponseMessage;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Integer> getTotalPrices() {
        return totalPrices;
    }

    public void setTotalPrices(List<Integer> totalPrices) {
        this.totalPrices = totalPrices;
    }

    public Integer getTotalRewards() {
        return totalRewards;
    }

    public void setTotalRewards(Integer totalRewards) {
        this.totalRewards = totalRewards;
    }

    public MonthlyReponseMessage getMonthlyReponseMessage() {
        return monthlyReponseMessage;
    }

    public void setMonthlyReponseMessage(MonthlyReponseMessage monthlyReponseMessage) {
        this.monthlyReponseMessage = monthlyReponseMessage;
    }
}
