Feature:Blibli Integration Testing

  Scenario Outline: End-to-End Flow - Order creation in blibli - Retail
    Given user fetch response from the api "https://wwwpreprod.gdn-app.com/backend/search/getSeedKeyword"
    And get the keyword from the response
    When user navigates to blibli site "https://wwwpreprod.gdn-app.com/"
    And user clicks login button
    And user enter username "<username>"
    And user enters password "<password>"
    And user clicks login
    And user enters the OTP "<otp>"
    Then user "<profileName>" logged successfully
    When user search the keyword fetched
    And user apply "<filter>" filter
    And user select a product
    And user add quantity <Quantity>
    And user add the address "<address>" with label "<label>" ,mobile: "<mobileNo>"
    And user change payment method to "<Bank>"
    And user change the shipment to "<shipment>"
    And user place order
    And user cancel the order
    And user verify the cancellation
    Examples:
    |username      |password |otp|profileName    |filter           |Quantity|address            |label  |mobileNo|Bank    |shipment|
    |+6281234500001|Test@1234|3  |Hi, Pranavasree|Disediakan Blibli|2       |South Tanjung Duren|Testing|08213450|Bank BNI|MAPAN   |