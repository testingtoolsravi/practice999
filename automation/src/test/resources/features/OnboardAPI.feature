@OnBoarding @api
Feature: Onboarding

  Background: User Has Logged into OnBoarding With Valid Credentials
    Given load base components

  @regression
  Scenario: Customer Types
    When user sends request for get customer types
    Then type of customers should be Returned as 'Commercial' and 'Consumer'

  @regression
  Scenario: Occupation Types
    When user sends request for get Occupation types
    Then type of Occupation should be Returned as 'Software Engineer' and 'Tailoring'

  @regression
  Scenario: Income Range Types
    When user sends request for get Income Range types
    Then type of Income Range should be Returned as '$25,000 - $50,000' and '$50,000 - $75,000'

  @regression
  Scenario: Nature of Business Types
    When user sends request for get Nature of Business types
    Then type of Nature of Business should be Returned as 'Transportation' and 'Financial'

  @regression
  Scenario Outline: Product Types
    When user sends request for get Product types
    Then type of Product should be Returned according to the Query Params productLine as '<productLine>'  and custType as '<custType>'

    Examples: 
      | productLine | custType   |
      | DEPOSIT     | Commercial |
      | LOAN        | Commercial |
      | LOAN        | Consumer   |
      | DEPOSIT     | Consumer   |

  @regression
  Scenario Outline: Products
    When user sends request for get Products
    Then type of Product should be Returned according to the Query Params custType as '<custType>'

    Examples: 
      | custType   |
      | Commercial |
      | Consumer   |
