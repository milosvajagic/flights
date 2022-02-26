Feature: BookingFlight

  Scenario Outline: Book a Flight row: "<row>"

    Given I load test data from "BookingFlight" "BookingSheetFlight" "<row>"
    And I navigate to Booking
    And I click on Flights
    When I add starting point
    And I add ending point
    And I add departure date and return date
    And I click search
    # click availability
    # verify search details
    Examples:
      | row |
      | 1 |

