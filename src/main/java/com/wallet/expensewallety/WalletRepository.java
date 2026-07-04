package com.wallet.expensewallety;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface WalletRepository extends JpaRepository<wallet,Integer> {
    List<wallet> findAll();

    
} 
