package com.banquemisr.persistence;



import javax.persistence.*;
//@EnableAutoConfiguration
@Table(name = "accounts")
@Entity
public class Account {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer acc_num;

    @Column(name = "type")
    private String type;

    @Column(name = "balance")
    private int balance;

    @ManyToOne
    @JoinColumn(name = "customer", nullable = false)
    private Customer customer;


    public Integer getAcc_num() {
        return acc_num;
    }

    public void setAcc_num(Integer acc_num) {
        this.acc_num = acc_num;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
