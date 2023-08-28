package com.example.demo.usecase

import com.example.demo.domain.EmailService
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
import org.thymeleaf.context.Context
import org.thymeleaf.spring6.SpringTemplateEngine

@Service
class DemoService(
  private val emailService: EmailService,
  @Qualifier("textEmailTemplateEngine") private val templateEngine: SpringTemplateEngine
) {

  fun sendEmail(address: String, name: String) {
    val message = createMessage(name)
    emailService.sendEmail(address, message)
    
  }

  fun createMessage(name: String): String {
    val context = Context()
    context.setVariable("name", name)
    return templateEngine.process("sample", context)
  }
}
