Feature: Make a reservation at Viva Air
  Like a tourist
  I want to make a reservation for a flight
  To be able to travel

  Scenario: Book the cheapest flight from Medellin to Bogota for tomorrow
    Given Cristian wants to book a flight with vivaair
    When Cristian books the cheapest flight from Medellin to Bogota
    Then Cristian verifies that the value of the initial flight is equal to the end