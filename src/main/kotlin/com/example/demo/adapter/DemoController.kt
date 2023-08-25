package com.example.demo.adapter

import com.example.demo.usecase.DemoService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/demo")
class DemoController(
  private val demoService: DemoService
) {

  @GetMapping
  fun demo(model: Model): String {
    model.addAttribute("emailForm", EmailForm())
    return "demo"
  }

  @PostMapping("/sendEmail")
  fun sendEmail(emailForm: EmailForm, model: Model): String {
    demoService.sendEmail(emailForm.address ?: "", emailForm.message ?: "")
    model.addAttribute("emailForm", emailForm)
    return "redirect:/demo"
  }
}
