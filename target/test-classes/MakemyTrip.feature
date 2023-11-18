Feature: Book Train Tickets in Make My Trip # to explain the flow of our testcase as a summary

Background: Launching Make My Trip #common function for scenario
Given Launch the MakeMyTrip Application "https://www.makemytrip.com/"
When User closes the ad
When User skips the login

Scenario: Book Train Ticket # to specify the process of scenario and it will execute one time only
When User clicks on train # Action
And User enters the from place with one dim list 
|Madurai|Chennai|Mumbai|
And User enters the to place with one dim map
|place1|Navi|
|place2|Pune|
|place3|Kolkata|
And User selects the travel date
And User clicks on search
Then Verify the  from place, to place, travel data and class# Post condition, Validation purpose

Scenario: Book Hotel # to specify the process of scenario and it will execute one time only 
When User clicks on hotel # Action
And User enters the hotel with one dim list 
|Madurai|Chennai|Tiruchirapalli|
And User selects the booking date with one dim map
|place1|Navi|
|place2|Pune|
|place3|Kolkata|
And User clicks on search
Then Verify the  hotel, booking date# Post condition, Validation purpose


