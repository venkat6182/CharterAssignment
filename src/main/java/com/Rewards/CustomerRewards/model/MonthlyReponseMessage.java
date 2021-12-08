package com.Rewards.CustomerRewards.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MonthlyReponseMessage {

    private Integer firstMonthRewards;
    private List<Integer> firstMonthPrices;
    private Integer secondMonthRewards;
    private List<Integer> secondMonthPrices;
    private Integer thirdMonthRewards;
    private List<Integer> thirdMonthPrices;

    public Integer getFirstMonthRewards() {
        return firstMonthRewards;
    }

    public void setFirstMonthRewards(Integer firstMonthRewards) {
        this.firstMonthRewards = firstMonthRewards;
    }

    public List<Integer> getFirstMonthPrices() {
        return firstMonthPrices;
    }

    public void setFirstMonthPrices(List<Integer> firstMonthPrices) {
        this.firstMonthPrices = firstMonthPrices;
    }

    public Integer getSecondMonthRewards() {
        return secondMonthRewards;
    }

    public void setSecondMonthRewards(Integer secondMonthRewards) {
        this.secondMonthRewards = secondMonthRewards;
    }

    public List<Integer> getSecondMonthPrices() {
        return secondMonthPrices;
    }

    public void setSecondMonthPrices(List<Integer> secondMonthPrices) {
        this.secondMonthPrices = secondMonthPrices;
    }

    public Integer getThirdMonthRewards() {
        return thirdMonthRewards;
    }

    public void setThirdMonthRewards(Integer thirdMonthRewards) {
        this.thirdMonthRewards = thirdMonthRewards;
    }

    public List<Integer> getThirdMonthPrices() {
        return thirdMonthPrices;
    }

    public void setThirdMonthPrices(List<Integer> thirdMonthPrices) {
        this.thirdMonthPrices = thirdMonthPrices;
    }
}
