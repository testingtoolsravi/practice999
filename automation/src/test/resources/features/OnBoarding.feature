@OnBoarding @Web @Regression
Feature: Onboarding

  Background: User Has Logged into OnBoarding With Valid Credentials
    Given user logged into Onboarding

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0001
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType          | CustomerType | ProductName                   |
      | Deposit     | Money Market Account | Consumer     | Consumer Money Market Account |
    And Fills the Details for the Individual Information
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0002
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType          | CustomerType | ProductName             |
      | Deposit     | Money Market Account | Commercial   | Commercial Money Market |
    And Fills the Details for the Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0003
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName          |
      | Deposit     | Checking    | Consumer     | Consumer Kasasa Cash |
    And Fills the Details for the Individual Information
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0004
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName           |
      | Deposit     | Checking    | Consumer     | Consumer Kasasa Saver |
    And Fills the Details for the Individual Information
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0005
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName           |
      | Deposit     | Checking    | Consumer     | Consumer 365 Checking |
    And Fills the Details for the Individual Information
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0006
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                  |
      | Deposit     | Checking    | Consumer     | Consumer TAB Chrome Checking |
    And Fills the Details for the Individual Information
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0007
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                  |
      | Deposit     | Checking    | Consumer     | Consumer High Yield Checking |
    And Fills the Details for the Individual Information
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0008
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                  |
      | Deposit     | Checking    | Commercial   | Commercial Business Checking |
    And Fills the Details for the Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0009
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                           |
      | Deposit     | Checking    | Commercial   | Commercial Analyzed Business Checking |
    And Fills the Details for the Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0010
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                           |
      | Deposit     | Checking    | Commercial   | Commercial Business Advantage Prepaid |
    And Fills the Details for the Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0011
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName          |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 12 Month CD |
    And Fills the Details for the Individual Information
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete consumer COD Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0012
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName          |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 18 Month CD |
    And Fills the Details for the Individual Information
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete consumer COD Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0013
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName          |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 24 Month CD |
    And Fills the Details for the Individual Information
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete consumer COD Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0014
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName         |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 3 Month CD |
    And Fills the Details for the Individual Information
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete consumer COD Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0015
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName          |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 36 Month CD |
    And Fills the Details for the Individual Information
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete consumer COD Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0016
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName          |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 48 Month CD |
    And Fills the Details for the Individual Information
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete consumer COD Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0017
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName         |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 6 Month CD |
    And Fills the Details for the Individual Information
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete consumer COD Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0018
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName          |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 60 Month CD |
    And Fills the Details for the Individual Information
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete consumer COD Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0019
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName         |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 9 Month CD |
    And Fills the Details for the Individual Information
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0020
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName           |
      | Deposit     | Certificate of Deposit | Commercial   | Commercial 9 Month CD |
    And Fills the Details for the Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0021
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName            |
      | Deposit     | Certificate of Deposit | Commercial   | Commercial 12 Month CD |
    And Fills the Details for the Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0022
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName            |
      | Deposit     | Certificate of Deposit | Commercial   | Commercial 18 Month CD |
    And Fills the Details for the Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0023
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName            |
      | Deposit     | Certificate of Deposit | Commercial   | Commercial 24 Month CD |
    And Fills the Details for the Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0024
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName            |
      | Deposit     | Certificate of Deposit | Commercial   | Commercial 36 Month CD |
    And Fills the Details for the Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0025
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName           |
      | Deposit     | Certificate of Deposit | Commercial   | Commercial 3 Month CD |
    And Fills the Details for the Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0026
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName            |
      | Deposit     | Certificate of Deposit | Commercial   | Commercial 48 Month CD |
    And Fills the Details for the Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0027
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName            |
      | Deposit     | Certificate of Deposit | Commercial   | Commercial 60 Month CD |
    And Fills the Details for the Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0028
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName           |
      | Deposit     | Certificate of Deposit | Commercial   | Commercial 6 Month CD |
    And Fills the Details for the Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0029
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                 |
      | Deposit     | Savings     | Consumer     | Consumer High Yield Savings |
    And Fills the Details for the Individual Information
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0030
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName              |
      | Deposit     | Savings     | Consumer     | Consumer Premium Savings |
    And Fills the Details for the Individual Information
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete Verifications and Create account

  @ONBRD1225 @Smoke
  Scenario: REG_ONBRD_1225_TC_0031
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                 |
      | Deposit     | Savings     | Commercial   | Commercial Business Savings |
    And Fills the Details for the Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial Savings Verifications and Create account

  @ONBRD1225 @Smoke @Loan
  Scenario: REG_ONBRD_1225_TC_0032
    Given User is Starting to create a Product
    When user creates a Loan product with specifications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                       | CDLDrivingYears |
      | Loan        | Equipment   | Commercial   | Commercial Small Ticket Equipment |               2 |
    And Fills the Details for the Loans Legal Entity
      | LegalEntity |
      | Corporation |
    Then Entity details should be saved
    When User fills opportunity ,collateral and Equipment Info and starts Process
      | BusinessType | Amount |
      | New Business |  14000 |
    Then user should be able to Start the Process
    And Complete the tasks generated for Small Ticket Loan

  @ONBRD1225 @Smoke @Loan
  Scenario: REG_ONBRD_1225_TC_0033
    Given User is Starting to create a Product
    When user creates a Loan product with specifications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                       | CDLDrivingYears |
      | Loan        | Equipment   | Commercial   | Commercial Large Ticket Equipment |               2 |
    And Fills the Details for the Loans Legal Entity
      | LegalEntity |
      | Corporation |
    Then Entity details should be saved
    When User fills opportunity ,collateral and Equipment Info and starts Process
      | BusinessType | Amount |
      | New Business |  14000 |
    Then user should be able to Start the Process
    When user completes the task generated for Large Ticket Loan

  @ONBRD1225 @Smoke @Loan
  Scenario: REG_ONBRD_1225_TC_0034
    Given User is Starting to create a Product
    When user creates a Loan product with specifications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName    |
      | Loan        | ABL         | Commercial   | Commercial ABL |
    And Fills the Details for the Loans Legal Entity
      | LegalEntity |
      | Corporation |
    Then Entity details should be saved
    When User fills opportunity ,collateral and Equipment Info and starts Process
      | BusinessType | Amount |
      | New Business |  14000 |
    Then user should be able to Start the Process
    When user completes the task generated for ABL Loan

  Scenario: REG_TC_0035
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType          | CustomerType | ProductName                   |
      | Deposit     | Money Market Account | Consumer     | Consumer Money Market Account |
    And Fills the Details for the Joint Applicant
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete Joint Applicant Verifications and Create account

  Scenario: REG_TC_0036
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName          |
      | Deposit     | Checking    | Consumer     | Consumer Kasasa Cash |
    And Fills the Details for the Joint Applicant
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete Joint Applicant Verifications and Create account

  Scenario: REG_TC_0037
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName           |
      | Deposit     | Checking    | Consumer     | Consumer Kasasa Saver |
    And Fills the Details for the Joint Applicant
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete Joint Applicant Verifications and Create account

  Scenario: REG_TC_0038
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName           |
      | Deposit     | Checking    | Consumer     | Consumer 365 Checking |
    And Fills the Details for the Joint Applicant
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete Joint Applicant Verifications and Create account

  Scenario: REG_TC_0039
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                  |
      | Deposit     | Checking    | Consumer     | Consumer TAB Chrome Checking |
    And Fills the Details for the Joint Applicant
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete Joint Applicant Verifications and Create account

  Scenario: REG_TC_0040
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                  |
      | Deposit     | Checking    | Consumer     | Consumer High Yield Checking |
    And Fills the Details for the Joint Applicant
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete Joint Applicant Verifications and Create account

  Scenario: REG_TC_0041
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType          | CustomerType | ProductName             |
      | Deposit     | Money Market Account | Commercial   | Commercial Money Market |
    And Fills the Details for the Joint Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
      | Individual      |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial Verifications and Create account

  Scenario: REG_TC_0042
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                  |
      | Deposit     | Checking    | Commercial   | Commercial Business Checking |
    And Fills the Details for the Joint Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
      | Individual      |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial Verifications and Create account

  Scenario: REG_TC_0043
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                           |
      | Deposit     | Checking    | Commercial   | Commercial Analyzed Business Checking |
    And Fills the Details for the Joint Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
      | Individual      |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial Verifications and Create account

  Scenario: REG_TC_0044
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                           |
      | Deposit     | Checking    | Commercial   | Commercial Business Advantage Prepaid |
    And Fills the Details for the Joint Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
      | Individual      |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial Verifications and Create account

  Scenario: REG_TC_0045
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName          |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 12 Month CD |
    And Fills the Details for the Joint Applicant
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete consumer COD Verifications and Create account

  Scenario: REG_TC_0046
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName          |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 18 Month CD |
    And Fills the Details for the Joint Applicant
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete consumer COD Verifications and Create account

  Scenario: REG_TC_0047
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName          |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 24 Month CD |
    And Fills the Details for the Joint Applicant
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete consumer COD Verifications and Create account

  Scenario: REG_TC_0048
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName         |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 3 Month CD |
    And Fills the Details for the Joint Applicant
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete consumer COD Verifications and Create account

  Scenario: REG_TC_0049
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName          |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 36 Month CD |
    And Fills the Details for the Joint Applicant
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete consumer COD Verifications and Create account

  Scenario: REG_TC_0050
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName          |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 48 Month CD |
    And Fills the Details for the Joint Applicant
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete consumer COD Verifications and Create account

  Scenario: REG_TC_0051
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName         |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 6 Month CD |
    And Fills the Details for the Joint Applicant
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete consumer COD Verifications and Create account

  Scenario: REG_TC_0052
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName          |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 60 Month CD |
    And Fills the Details for the Joint Applicant
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete consumer COD Verifications and Create account

  Scenario: REG_TC_0053
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName         |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 9 Month CD |
    And Fills the Details for the Joint Applicant
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  Scenario: REG_TC_0054
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName           |
      | Deposit     | Certificate of Deposit | Commercial   | Commercial 9 Month CD |
    And Fills the Details for the Joint Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
      | Individual      |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  Scenario: REG_TC_0055
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName            |
      | Deposit     | Certificate of Deposit | Commercial   | Commercial 12 Month CD |
    And Fills the Details for the Joint Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
      | Individual      |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  Scenario: REG_TC_0056
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName            |
      | Deposit     | Certificate of Deposit | Commercial   | Commercial 18 Month CD |
    And Fills the Details for the Joint Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
      | Individual      |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  Scenario: REG_TC_0057
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName            |
      | Deposit     | Certificate of Deposit | Commercial   | Commercial 24 Month CD |
    And Fills the Details for the Joint Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
      | Individual      |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  Scenario: REG_TC_0058
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName            |
      | Deposit     | Certificate of Deposit | Commercial   | Commercial 36 Month CD |
    And Fills the Details for the Joint Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
      | Individual      |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  Scenario: REG_TC_0059
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName           |
      | Deposit     | Certificate of Deposit | Commercial   | Commercial 3 Month CD |
    And Fills the Details for the Joint Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
      | Individual      |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  Scenario: REG_TC_0060
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName            |
      | Deposit     | Certificate of Deposit | Commercial   | Commercial 48 Month CD |
    And Fills the Details for the Joint Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
      | Individual      |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  Scenario: REG_TC_0061
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName            |
      | Deposit     | Certificate of Deposit | Commercial   | Commercial 60 Month CD |
    And Fills the Details for the Joint Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
      | Individual      |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  Scenario: REG_TC_0062
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName           |
      | Deposit     | Certificate of Deposit | Commercial   | Commercial 6 Month CD |
    And Fills the Details for the Joint Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
      | Individual      |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial COD Verifications and Create account

  Scenario: REG_TC_0063
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                 |
      | Deposit     | Savings     | Consumer     | Consumer High Yield Savings |
    And Fills the Details for the Joint Applicant
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete Joint Applicant Verifications and Create account

  Scenario: REG_TC_0064
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName              |
      | Deposit     | Savings     | Consumer     | Consumer Premium Savings |
    And Fills the Details for the Joint Applicant
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete Joint Applicant Verifications and Create account

  Scenario: REG_TC_0065
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                 |
      | Deposit     | Savings     | Commercial   | Commercial Business Savings |
    And Fills the Details for the Joint Legal Entity
      | LegalEntity     |
      | Sole Proprietor |
      | Individual      |
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete commercial Savings Verifications and Create account

  @Loan
  Scenario: REG_TC_0066
    Given User is Starting to create a Product
    When user creates a Loan product with specifications and Clicks create
      | ProductLine | ProductType   | CustomerType | ProductName              |
      | Loan        | Participation | Commercial   | Commercial Participation |
    And Fills the Details for the Loans Legal Entity
      | LegalEntity |
      | Corporation |
    Then Entity details should be saved
    When User fills opportunity ,collateral  and starts Process
      | BusinessType | Amount |
      | New Business |  14000 |
    Then user should be able to Start the Process
    When user completes the task generated for Participation Loan

  @Loan
  Scenario: REG_TC_0067
    Given User is Starting to create a Product
    When user creates a Loan product with specifications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName           |
      | Loan        | Rediscount  | Commercial   | Commercial Rediscount |
    And Fills the Details for the Loans Legal Entity
      | LegalEntity |
      | Corporation |
    Then Entity details should be saved
    When User fills opportunity ,collateral  and starts Process
      | BusinessType | Amount |
      | New Business |  14000 |
    Then user should be able to Start the Process
    When user completes the task generated for Rediscount Loan

  @Loan
  Scenario: REG_TC_0068
    Given User is Starting to create a Product
    When user creates a Loan product with specifications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                       |
      | Loan        | Factoring   | Commercial   | Commercial Small Ticket Factoring |
    And Fills the Details for the Loans Legal Entity
      | LegalEntity |
      | Corporation |
    Then Entity details should be saved
    When User fills opportunity ,collateral  and starts Process
      | BusinessType | Amount |
      | New Business |  14000 |
    Then user should be able to Start the Process
    When user completes the task generated for Small Ticket Factoring Loan

  @Loan
  Scenario: REG_TC_0070
    Given User is Starting to create a Product
    When user creates a Loan product with specifications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName           |
      | Loan        | Smart Loan  | Commercial   | Commercial SmartLoans |
    And Fills the Details for the Loans Legal Entity
      | LegalEntity |
      | Corporation |
    Then Entity details should be saved
    When user adds Indiviudal Info Starts the Loan Process
    Then user completes the task generated for Smart Loan

  Scenario: REG_TC_0071
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType          | CustomerType | ProductName                   |
      | Deposit     | Money Market Account | Consumer     | Consumer Money Market Account |
    And Fills Individual Info and starts the process
    Then User should be Able to Decline the Application from HomePage

  Scenario: REG_TC_0072
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName          |
      | Deposit     | Checking    | Consumer     | Consumer Kasasa Cash |
    And Fills Individual Info and starts the process
    Then User should be Able to Decline the Application from HomePage

  Scenario: REG_TC_0073
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName          |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 12 Month CD |
    And Fills Individual Info and starts the process
    Then User should be Able to Decline the Application from HomePage

  Scenario: REG_TC_0074
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                 |
      | Deposit     | Savings     | Consumer     | Consumer High Yield Savings |
    And Fills Individual Info and starts the process
    Then User should be Able to Decline the Application from HomePage

  Scenario: REG_TC_0075
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType          | CustomerType | ProductName                   |
      | Deposit     | Money Market Account | Consumer     | Consumer Money Market Account |
    And Fills Individual Info and starts the process
    Then User should be Able to WithDraw the Application from HomePage

  Scenario: REG_TC_0076
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName          |
      | Deposit     | Checking    | Consumer     | Consumer Kasasa Cash |
    And Fills Individual Info and starts the process
    Then User should be Able to WithDraw the Application from HomePage

  Scenario: REG_TC_0077
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName          |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 12 Month CD |
    And Fills Individual Info and starts the process
    Then User should be Able to WithDraw the Application from HomePage

  Scenario: REG_TC_0078
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                 |
      | Deposit     | Savings     | Consumer     | Consumer High Yield Savings |
    And Fills Individual Info and starts the process
    Then User should be Able to WithDraw the Application from HomePage

  @TODO @BUG
  Scenario: REG_TC_0079
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType          | CustomerType | ProductName                   |
      | Deposit     | Money Market Account | Consumer     | Consumer Money Market Account |
    And Fills Individual Info and starts the process
    Then User should be Able to Decline the Application from HomePage
    When user Starts process for Declined Application from HomePage
    Then User should be able to complete the Deposit tasks

  @TODO @BUG
  Scenario: REG_TC_0080
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName          |
      | Deposit     | Checking    | Consumer     | Consumer Kasasa Cash |
    And Fills Individual Info and starts the process
    Then User should be Able to Decline the Application from HomePage
    When user Starts process for Declined Application from HomePage
    Then User should be able to complete the Deposit tasks

  @TODO @BUG
  Scenario: REG_TC_0081
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType            | CustomerType | ProductName          |
      | Deposit     | Certificate of Deposit | Consumer     | Consumer 12 Month CD |
    And Fills Individual Info and starts the process
    Then User should be Able to Decline the Application from HomePage
    When user Starts process for Declined Application from HomePage
    Then User should be able to complete the Deposit tasks

  @TODO @BUG
  Scenario: REG_TC_0082
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                 |
      | Deposit     | Savings     | Consumer     | Consumer High Yield Savings |
    And Fills Individual Info and starts the process
    Then User should be Able to Decline the Application from HomePage
    When user Starts process for Declined Application from HomePage
    Then User should be able to complete the Deposit tasks

      
  Scenario: REG_TC_0083
    Given User is Starting to create a Product
    When user creates a Deposit product with specfications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                 |
      | Deposit     | Savings     | Consumer     | Consumer High Yield Savings |
    And Fills the Details for the Individual Information
    Then Product should be added in OnBoarding results Table
    And User should be able to Complete Verifications and Create account
    
    
   
    
    @Loan 
  Scenario: REG_TC_0084
    Given User is Starting to create a Product
    When user creates a Loan product with specifications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                       | CDLDrivingYears |
      | Loan        | Equipment   | Commercial   | Commercial Small Ticket Equipment |               2 |
    And Fills the Details for the Loans Legal Entity
      | LegalEntity |
      | Corporation |
    Then Entity details should be saved
    When User fills opportunity ,collateral and Equipment Info and starts Process
      | BusinessType | Amount |
      | New Business |  14000 |
    Then user should be able to Start the Process
    When User navigates to Applications homepage
    Then User should be Able to WithDraw the Loan Application from HomePage
    
    
  @Loan 
  Scenario: REG_TC_0085
    Given User is Starting to create a Product
    When user creates a Loan product with specifications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName           |
      | Loan        | Smart Loan  | Commercial   | Commercial SmartLoans |
    And Fills the Details for the Loans Legal Entity
      | LegalEntity |
      | Corporation |
    Then Entity details should be saved
    When user adds Indiviudal Info Starts the Loan Process
    And User navigates to Applications homepage
    Then User should be Able to WithDraw the Loan Application from HomePage
    
    @Loan    
  Scenario: REG_TC_0086
    Given User is Starting to create a Product
    When user creates a Loan product with specifications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                       |
      | Loan        | Factoring   | Commercial   | Commercial Small Ticket Factoring |
    And Fills the Details for the Loans Legal Entity
      | LegalEntity |
      | Corporation |
    Then Entity details should be saved
    When User fills opportunity ,collateral  and starts Process
      | BusinessType | Amount |
      | New Business |  14000 |
    Then user should be able to Start the Process
    When User navigates to Applications homepage
    Then User should be Able to WithDraw the Loan Application from HomePage
    
    @Loan 
  Scenario: REG_TC_0087
    Given User is Starting to create a Product
    When user creates a Loan product with specifications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName    |
      | Loan        | ABL         | Commercial   | Commercial ABL |
    And Fills the Details for the Loans Legal Entity
      | LegalEntity |
      | Corporation |
    Then Entity details should be saved
    When User fills opportunity ,collateral and Equipment Info and starts Process
      | BusinessType | Amount |
      | New Business |  14000 |
    Then user should be able to Start the Process
    When User navigates to Applications homepage
    Then User should be Able to WithDraw the Loan Application from HomePage
    
     @Loan @T
  Scenario: REG_TC_0088
    Given User is Starting to create a Product
    When user creates a Loan product with specifications and Clicks create
      | ProductLine | ProductType | CustomerType | ProductName                       | CDLDrivingYears |
      | Loan        | Equipment   | Commercial   | Commercial Small Ticket Equipment |               2 |
    And Fills the Details for the Loans Legal Entity
      | LegalEntity |
      | Corporation |
    Then Entity details should be saved
    When User fills opportunity ,collateral and Equipment Info and starts Process
      | BusinessType | Amount |
      | New Business |  14000 |
    Then user should be able to Start the Process
    When User Declines the Loan Application from HomePage
    Then  User should be able to Complete the Decline task generated for Small Ticket Loan