package com.example.demo.usecase

import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.thymeleaf.context.Context
import org.thymeleaf.spring6.SpringTemplateEngine
import java.time.LocalDateTime

@Service
class DemoService(
  @Qualifier("textEmailTemplateEngine") private val templateEngine: SpringTemplateEngine
) {

  fun sendEmail(address: String, message: String) {
    println("address: $address")
    println(createMessage(message))
  }

  fun createMessage(message: String): String {
    val context = Context()
    context.setVariable("date", LocalDateTime.now())
    context.setVariable("message", message)
    return templateEngine.process("sample", context)
  }
}
