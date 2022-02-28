Feature: BookingFlight

  Scenario Outline: Book a Flight row: "<row>"

    Given I load test data from "BookingFlight" "BookingSheetFlight" "<row>"
    And I navigate to Booking
    And I click on Flights
    When I add starting point
    And I add ending point
    And I add departure date and return date
    And I click search
    When I change first stop filter
    And I select departs time
    And I click on See flight button
    And I click on Select button
    When I click Next button
    Then I populate Contact Details
    # click availability
    # verify search details
    Examples:
      | row |
      | 1 |
      | 2 |

