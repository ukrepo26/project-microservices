package com.genie.Payment_Gateway.Repo;

import com.genie.Payment_Gateway.Entity.PaymentOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentOrder,Long> {


    PaymentOrder findByOrderId(String orderId);
}
