package com.banquemisr.persistence;

import com.banquemisr.DTOs.CustomerDTO;

import javax.persistence.*;
import java.util.Date;

//@EnableAutoConfiguration
@Table(name = "customers")
@Entity
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "balance")
    private Long balance;

    @Column(name = "address")
    private String address;

    @Temporal(TemporalType.DATE)
    @Column(name = "dueDate")
    private Date dueDate;


    public void fill(CustomerDTO customerDTO)
    {
        this.id = customerDTO.getId();
        this.name = customerDTO.getName();
        this.balance = customerDTO.getBalance();
        this.address = customerDTO.getAddress();
        this.dueDate = customerDTO.getDueDate();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                ", address='" + address + '\'' +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
