package com.abc.paymentservice.userservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.abc.paymentservice.entity.Payment;
import com.abc.paymentservice.model.BookingDetails;
import com.abc.paymentservice.repository.PaymentRepository;
import com.abc.paymentservice.service.BookingDetailsService;
import com.abc.paymentservice.service.PaymentServiceImpl;


@SpringBootTest
public class PaymentTest {
	 @Mock
	    private PaymentRepository paymentRepository;

	    @Mock
	    private BookingDetailsService bookingService;

	    @InjectMocks
	    private PaymentServiceImpl paymentService;

	    @Test
	    public void testCreatePayment() {
	        // Prepare test data
	        Payment payment = new Payment();
	        payment.setPaymentId(1);
	        payment.setBookingId(1);
	        payment.setPayAmount("2000");

	        BookingDetails booking = new BookingDetails();
	        booking.setBookingId(1);
	        booking.setAmount("2000");

	        when(bookingService.getBookingDetailById(payment.getBookingId())).thenReturn(booking);

	        when(paymentRepository.save(payment)).thenReturn(payment);

	        Payment savedPayment = paymentService.createPayment(1, payment);

	        verify(bookingService, times(1)).getBookingDetailById(payment.getBookingId());
	        verify(paymentRepository, times(1)).save(payment);
	        assertEquals(payment, savedPayment);
	    }
	
	    @Test
	    public void testGetPaymentDetails() {
	        int paymentId = 1;
	        Payment payment = new Payment();
	        payment.setPaymentId(paymentId);
	        payment.setBookingId(2);
	        payment.setPayAmount("2500");

	        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(payment));

	        Payment retrievedPayment = paymentService.getPaymentDetails(paymentId);

	        verify(paymentRepository, times(1)).findById(paymentId);
	        assertNotNull(retrievedPayment);
	        assertEquals(payment, retrievedPayment);
	    }
	    
	    @Test
	    public void testGetAllPaymentsDetails() {
	        // Prepare test data
	        Payment payment1 = new Payment();
	        payment1.setPaymentId(1);
	        payment1.setBookingId(3);
	        payment1.setPayAmount("3000");
	        Payment payment2 = new Payment();
	        payment2.setPaymentId(2);
	        payment2.setBookingId(4);
	        payment2.setPayAmount("4000");
	        List<Payment> payments =  new ArrayList<>();
	        payments.add(payment1);
	        payments.add(payment2);
	        
	        
	        when(paymentRepository.findAll()).thenReturn(payments);
	        
	        List<Payment> retrievedPayments = paymentService.getAllPaymentsDetails();
	        verify(paymentRepository, times(1)).findAll();
	        
	        assertEquals(payments.size(), retrievedPayments.size());
	        assertEquals(payments, retrievedPayments);
	    }
		
	}
	
	
	


