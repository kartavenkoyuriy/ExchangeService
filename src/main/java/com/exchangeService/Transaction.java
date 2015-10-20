package com.exchangeService;

import java.util.Date;

public class Transaction {
    private int id;
    private Date date;
    private Wallet walletIdFrom;
    private Wallet walletIdTo;
    private int amountToSend;
    private Account account; //rename to accountOwner?
    private double exchangeRate; //another implementation?

    public Transaction(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Wallet getWalletIdFrom() {
        return walletIdFrom;
    }

    public void setWalletIdFrom(Wallet walletIdFrom) {
        this.walletIdFrom = walletIdFrom;
    }

    public Wallet getWalletIdTo() {
        return walletIdTo;
    }

    public void setWalletIdTo(Wallet walletIdTo) {
        this.walletIdTo = walletIdTo;
    }

    public int getAmountToSend() {
        return amountToSend;
    }

    public void setAmountToSend(int amountToSend) {
        this.amountToSend = amountToSend;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }
}
