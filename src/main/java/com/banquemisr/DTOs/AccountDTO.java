package com.banquemisr.DTOs;

import com.banquemisr.persistence.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AccountDTO {

    @Autowired
    ModelMapper modelMapper;


    int acc_num;
    String type;
    int balance;
    CustomerDTO customer;

    public AccountDTO(int acc_num, String type, int balance, CustomerDTO customer) {
        this.acc_num = acc_num;
        this.type = type;
        this.balance = balance;
        this.customer = new CustomerDTO(customer);
    }

    public int getAcc_num() {
        return acc_num;
    }

    public void setAcc_num(int acc_num) {
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

    public CustomerDTO getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerDTO customer) {
        this.customer = new CustomerDTO(customer);
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "acc_num=" + acc_num +
                ", type='" + type + '\'' +
                ", balance=" + balance +
                ", customer" + customer.toString() +
                '}';
    }
}
