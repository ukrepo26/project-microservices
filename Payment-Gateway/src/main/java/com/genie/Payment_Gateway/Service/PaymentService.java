package com.genie.Payment_Gateway.Service;

import com.genie.Payment_Gateway.Entity.PaymentOrder;
import com.genie.Payment_Gateway.Repo.PaymentRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
     private PaymentRepository paymentRepository;

    @Autowired
    EmailService emailService;

    @Value("${razorpay.key_id}")
    private  String keyId;

    @Value("${razorpay.key_secret}")
    private  String keySecret;

    public String createOrder(PaymentOrder OrderDetails) throws RazorpayException {
        RazorpayClient client=new RazorpayClient(keyId,keySecret);

        JSONObject orderRequest=new JSONObject();
        orderRequest.put("amount",(int)(OrderDetails.getAmount()*100));
        orderRequest.put("currency","INR");
        orderRequest.put("receipt","txn_"+ UUID.randomUUID());

        Order razorpayOrder=client.orders.create(orderRequest);
        System.out.println(razorpayOrder.toString());
        OrderDetails.setOrderId(razorpayOrder.get("id"));
         OrderDetails.setStatus("CREATED");
         OrderDetails.setCreatedAt(LocalDateTime.now());

         paymentRepository.save(OrderDetails);
        return razorpayOrder.toString();


    }

    public void updateOrderStatus(String paymentId, String orderId, String status) {
         PaymentOrder order=paymentRepository.findByOrderId(orderId);
         order.setPaymentId(paymentId);
         order.setStatus(status);
         paymentRepository.save(order);

         if ("SUCCESS".equalsIgnoreCase(status))
         {
            emailService.sendEmail(order.getEmail(),order.getName(),order.getCourseName(),order.getAmount());
         }

    }


}
