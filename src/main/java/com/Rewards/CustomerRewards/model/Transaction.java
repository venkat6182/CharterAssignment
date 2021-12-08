package com.Rewards.CustomerRewards.model;

import org.springframework.stereotype.Component;

@Component
public class Transaction {

    private Integer transactionId;
    private String customerId;
    private String month;
    private Integer price;

    public Integer getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(Integer transactionId) {
        this.transactionId = transactionId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }



    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", month='" + month + '\'' +
                ", customerId=" + customerId +
                ", price=" + price +
                '}';
    }
}
