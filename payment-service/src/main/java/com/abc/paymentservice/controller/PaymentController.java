package com.abc.paymentservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.paymentservice.entity.Payment;
import com.abc.paymentservice.model.BookingDetails;
import com.abc.paymentservice.service.PaymentService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public ResponseEntity<Payment> addPayment(@RequestBody int bookingId,Payment payment) {
        Payment savedPayment = paymentService.createPayment(bookingId,payment);
        return ResponseEntity.status(HttpStatus.OK).body(savedPayment);
    }

     
      @GetMapping("/{paymentId}")
      public ResponseEntity<Payment> getPaymentDetails(@PathVariable int paymentId) {
          Payment payment = paymentService.getPaymentDetails(paymentId);
          if (payment != null) {
              return new ResponseEntity<>(payment, HttpStatus.OK);
          } else {
              return new ResponseEntity<>(HttpStatus.NOT_FOUND);
          }
      }

      @GetMapping("/all")
      public ResponseEntity<List<Payment>> viewAllPayments() {
          List<Payment> payments = paymentService.getAllPaymentsDetails();
          return new ResponseEntity<>(payments, HttpStatus.OK);
      }
}