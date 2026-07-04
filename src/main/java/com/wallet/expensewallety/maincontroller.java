package com.wallet.expensewallety;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@CrossOrigin("*")

public class maincontroller {
    int balance = 0;
    int credit = 0;
    int debit = 0;
    @Autowired
    UserRepository repo;
    @PostMapping("/register")
    public String register(@RequestParam String username, @RequestParam String email, @RequestParam String password) {
        user existing = repo.findByEmail(email);
        if(existing != null){
            return "Email Already Exist";
        }
        user u = new user();
        u.setUsername(username);
        u.setEmail(email);
        u.setPassword(password);
         repo.save(u);
         return "Signup successfull";
    }
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        user user = repo.findByEmail(email);
        if(user == null){
            return "User not found";
        }
        if(user.getPassword().equals(password)){
            return "success";
        }
        return "Invalid password";
    }
    @Autowired
    WalletRepository walletrepo;
    @GetMapping("/add")
    public wallet add(@RequestParam String title, @RequestParam String type, @RequestParam int amount) {
        if(type.equals("credit")){
            balance += amount;
            credit += amount;
        }
        else{
            balance -= amount;
            debit += amount;
        }
       wallet w = new wallet();
       w.setTitle(title);
       w.setType(type);
       w.setAmount(amount);
       w.setCredit(credit);
       w.setDebit(debit);
       w.setBalance(balance);
       return walletrepo.save(w);
     
       
    }
    @GetMapping("/summarywallet")
    public List<wallet> getDetails() {
        return walletrepo.findAll();
    }
    @GetMapping("/walletcount")
    public long walletcount() {
        return walletrepo.count();
    }
    

   
   
    
}
