package com.example.demo.domain

import org.springframework.stereotype.Service

@Service
class EmailService {
  
  fun sendEmail(address: String, message: String) {
    println("address: $address")
    println(message)
  }
}