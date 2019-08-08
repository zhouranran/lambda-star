package cn.com.star.lanmbda.model;

public class Transaction {
    private Trader trader;
    private int year;
    private int amount;

    public Transaction(Trader trader, int year, int amount) {
        this.trader = trader;
        this.year = year;
        this.amount = amount;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
