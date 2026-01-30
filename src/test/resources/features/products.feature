Feature: Products API Test

  Scenario: Ürün listesini başarıyla getir
    Given url 'http://localhost:8089/products'
    When method get
    Then status 200

  Scenario: Yeni ürün başarılı şekilde eklenir
    Given url 'http://localhost:8089/products'
    And request
      """
      {
        "name": "Test Product",
        "description": "Test açıklaması",
        "price": 305,
        "stock": 10,
        "categoryId": 900719935,
      }
      """
    When method post
    Then status 200
    And match response.success == true
    And match response.data.id != null

