package com.reis.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController
{
  @GetMapping("/")
  public String redirectToSwagger() {
    return "redirect:/swagger-ui/index.html";
  }

}
