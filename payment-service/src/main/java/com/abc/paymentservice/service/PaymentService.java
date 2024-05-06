package com.abc.paymentservice.service;

import java.util.List;

import com.abc.paymentservice.entity.Payment;

public interface PaymentService {
	    Payment getPaymentDetails(int paymentId);
	    List<Payment> getAllPaymentsDetails();
	    Payment createPayment(int bookingId,Payment payment);
	    
	}

