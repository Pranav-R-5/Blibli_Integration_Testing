Feature:Blibli Integration Testing

  Scenario: End-to-End Flow - Order creation in blibli - Retail
    Given user fetch response from the api "https://wwwpreprod.gdn-app.com/backend/search/getSeedKeyword"
    And get the keyword from the response
    When user navigates to blibli site "https://wwwpreprod.gdn-app.com/"
    And user clicks login button
    And user enter username "+6281234500001"
    And user enters password "Test@1234"
    And user clicks login
    And user enters the OTP "3"
    When user search the keyword fetched
    And user apply distekan blibli filter
    And user select a product
    And user add quantity 2
    And user add the address "South Tanjung Duren"
    And user change payment method
    And user place order
    And user cancel the order
    And user verify the cancellation