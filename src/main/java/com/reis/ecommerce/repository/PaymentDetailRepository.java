package com.reis.ecommerce.repository;

import com.reis.ecommerce.model.PaymentDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentDetailRepository extends JpaRepository<PaymentDetail, Long>
{

}
