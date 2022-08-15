package com.banquemisr.DTOs;

import com.banquemisr.persistence.Customer;

import java.sql.Timestamp;
import java.util.Date;

//Customer DTO
public class CustomerDTO {
    String name, address;
    Long balance;
    Integer id;
    Date dueDate;

    public CustomerDTO(){}

    public CustomerDTO(Integer id, String name, Long balance, String address, Timestamp dueDate)
    {
        this.id = id;
        this.name = name;
        this.balance = balance;
        this.address = address;
        this.dueDate = dueDate;
    }

    public CustomerDTO(CustomerDTO customerDTO)
    {
        this.id = customerDTO.id;
        this.name = customerDTO.name;
        this.balance = customerDTO.balance;
        this.address = customerDTO.address;
        this.dueDate = customerDTO.dueDate;
    }

    public CustomerDTO(Customer customer)
    {
        this.id = customer.getId();
        this.name = customer.getName();
        this.balance = customer.getBalance();
        this.address = customer.getAddress();
        this.dueDate = customer.getDueDate();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDueDate(Timestamp dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Long getBalance() {
        return balance;
    }

    public String getAddress() {
        return address;
    }

    public Date getDueDate() {
        return dueDate;
    }

    @Override
    public String toString()
    {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("ID: ").append(id);
        stringBuilder.append("\n");
        stringBuilder.append("Name: ").append(name);
        stringBuilder.append("\n");
        stringBuilder.append("Balance: ").append(balance);
        stringBuilder.append("\n");
        stringBuilder.append("Address: ").append(address);
        stringBuilder.append("\n");

        return stringBuilder.toString();
    }


}
