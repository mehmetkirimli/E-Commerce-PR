package com.reis.ecommerce.repository;

import com.reis.ecommerce.model.PaymentTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentTransactionRepository extends JpaRepository<PaymentTransaction, Long>
{

}
