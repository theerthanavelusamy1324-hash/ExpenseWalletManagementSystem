package com.wallet.expensewallety;
import jakarta.persistence.*;
@Entity
@Table(name="wallet")

public class wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int amount;
    private String type;
    private int balance;
    private int credit;
    private int debit;
    public wallet(){};
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
     public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }
    public String getType(){
        return type;
    }
    public void setType(String type){
        this.type = type;
    }
    public int getBalance(){
        return balance;
    }
    public void setBalance(int balance){
        this.balance = balance;
    }
    public int getCredit(){
        return credit;
    }
    public void setCredit(int credit){
        this.credit = credit;
    }
    public int getDebit(){
        return debit;
    }
    public void setDebit(int debit){
        this.debit = debit;
    }
    
}
