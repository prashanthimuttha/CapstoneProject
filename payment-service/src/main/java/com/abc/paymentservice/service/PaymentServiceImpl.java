package com.abc.paymentservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.paymentservice.entity.Payment;
import com.abc.paymentservice.exception.PaymentDeclinedException;
import com.abc.paymentservice.model.BookingDetails;
import com.abc.paymentservice.repository.PaymentRepository;

import jakarta.ws.rs.NotFoundException;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private BookingDetailsService bookingService;


	@Override
	public Payment getPaymentDetails(int paymentId) {
		return paymentRepository.findById(paymentId).orElseThrow(() -> new NotFoundException("Payment not found"));
	}

	@Override
	public List<Payment> getAllPaymentsDetails() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment createPayment(int bookingId, Payment payment) {
		BookingDetails booking = bookingService.getBookingDetailById(payment.getBookingId());
		if(payment.getPayAmount().equals(booking.getAmount())) {
			 Payment processedPayment = paymentRepository.save(payment);
	            return processedPayment;
		}
		else {
			 throw new RuntimeException("Payment declined");
	}
}
}
