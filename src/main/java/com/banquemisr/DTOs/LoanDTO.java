package com.banquemisr.DTOs;

public class LoanDTO {
    int loan_num;
    int amount;
    String status;
    int acc_num;

    public LoanDTO(int loan_num, int amount, String status, int acc_num) {
        this.loan_num = loan_num;
        this.amount = amount;
        this.status = status;
        this.acc_num = acc_num;
    }

    public int getLoan_num() {
        return loan_num;
    }

    public void setLoan_num(int loan_num) {
        this.loan_num = loan_num;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getAcc_num() {
        return acc_num;
    }

    public void setAcc_num(int acc_num) {
        this.acc_num = acc_num;
    }

    @Override
    public String toString() {
        return "LoanDTO{" +
                "loan_num=" + loan_num +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                ", acc_num=" + acc_num +
                '}';
    }
}
