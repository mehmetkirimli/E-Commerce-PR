package com.reis.ecommerce;

import com.intuit.karate.junit5.Karate;

public class KarateTestRunner
{
  @Karate.Test
  Karate testAll(){
    return Karate.run("classpath:features/products.feature");
  }

  // ✔ Bu sınıf Karate’yi tetikleyecek
  // ✔ Feature dosyanı bulacak
  // ✔ GET /products isteğini gerçekten çalıştıracak


}
