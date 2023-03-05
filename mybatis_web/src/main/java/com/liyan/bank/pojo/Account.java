package com.liyan.bank.pojo;

/**
 * @ClassName Account
 * @Description TODO
 * @Author Li Yan
 * @Date 2023/3/5 19:01
 * @Version 1.0
 */
public class Account {
    private int id;
    private String actno;
    private Double balance;

    public Account() {
    }

    public Account(int id, String actno, Double balance) {
        this.id = id;
        this.actno = actno;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActno() {
        return actno;
    }

    public void setActno(String actno) {
        this.actno = actno;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", actno='" + actno + '\'' +
                ", balance=" + balance +
                '}';
    }
}
