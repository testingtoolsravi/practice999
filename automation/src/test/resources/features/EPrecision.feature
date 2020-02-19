@EPrecision @Web @Regression
Feature: EPrecision

  Background: User Has Logged into EPrecision With Valid Credentials
    Given user logged into EPrecision as 'admin' and 'admin'

 
  Scenario: TC_ePrecision_0001
     
    When User is logged in to EPrecision and at HomePage
    Then on Homepage below options should be available
     | Fist Data | Precision | Administration | Help | 
  @Smoke
  Scenario: TC_ePrecision_0002
    Given User is Logged in to EPrecsions
    When User navigates to process Errors
    Then User should be able to see below  options
      | Sent | Account | Card | Error Code | Process | Message | Reviewed |

  @Smoke
  Scenario: TC_ePrecision_0003
    Given User is Logged in to EPrecsions
    When User navigates to End of Day Jobs
    Then User should be able to see All End of Day Jobs options
 
  Scenario: TC_ePrecision_0004
    Given User is Logged in to EPrecsions
    When User navigates to End of Day Jobs and Clicks on All End of Day Jobs options
    Then Relative Message should be displayed to the User
    
    @TODO
  Scenario: TC_ePrecision_0005
    Given User is Logged in to EPrecsions
    When User navigates to Product Templates Page
    Then User should be able to Create Edit and Remove a Template
    
     
  Scenario: TC_ePrecision_0006
    Given User is Logged in to EPrecsions
    When User Expands the Precision Tab
    Then Precision Tab should have below options
    |Sonic|Ping|
  @Smoke
  Scenario: TC_ePrecision_0007
    Given User is Logged in to EPrecsions
    When User navigates to Precision
    Then User should be able to see All Precision tab options
 
  Scenario: TC_ePrecision_0008
    Given User is Logged in to EPrecsions
    When user navigates to Cif Entity option
    Then User should be able to see below  options on CIF Entity Page
      | Search | Add Search Condition | Create | Edit | Remove | 
  @Smoke  
  Scenario: TC_ePrecision_0009
    Given User is Logged in to EPrecsions
    When User navigates to Precision
    Then User should be able to see All Precision tab options
    When user navigates to Cif Entity option
    Then user should be able to create Edit  Remove and search for the CIF Entity
      | Branch     | IbFlag | Ib2Flag | newIb2Flag |
      | 1 TAB Bank |      1 |       0 |          1 |

  @Smoke 
  Scenario: TC_ePrecision_010
    Given User is Logged in to EPrecsions
    When User navigates to Precision
    Then User should be able to see All Precision tab options
    When user navigates to Ping options
    Then user Should be able to See Ping Options
    When user clicks on Ping Sonic button
    Then System up Message Should be Displayed
