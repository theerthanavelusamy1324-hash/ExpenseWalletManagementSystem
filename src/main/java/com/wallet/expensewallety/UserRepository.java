package com.wallet.expensewallety;
import org.springframework.data.jpa.repository.JpaRepository;



public interface UserRepository extends JpaRepository<user,Integer> {
    user findByEmail(String email);

    
} 
