package com.banquemisr.persistence;


import javax.persistence.*;

@Table (name = "loans")
@Entity
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long loan_num;

    @Column
    private long amount;

//    @Column
//    private Loan_Status status;

    @ManyToOne
    @JoinColumn(name = "acc_num", nullable = false)
    private Account accountID;


}
