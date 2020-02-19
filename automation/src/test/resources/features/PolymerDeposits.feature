@PolymerDeposits @Web @Regression
Feature: Polymer Deposits
  

  Background: Load User Data
    Given User Test Data is loaded

 @Smoke
  Scenario: Tc_001
    Given User is on DOA HomePage
    When User selects service type as 'Personal'
    And Product as 'Certificate of Deposit','3 Month CD'
    Then On Clicking OpenNow User should be Navigated to Basic InformationPage
    When User fills all Basic Information and clicks Next
      | incomeRange | politicallyExposedPerson | businessOrCommercialPurpose |
      | $100,000+   | No                       | No                          |
    Then Certificate of Deposit Page should be displayed
    When User fills Details for COD Page and click Next
      | frequency | method       |
      | Monthly   | Posted to CD |
    Then Agreements Page Should be loaded
    When User Submits the Application
    Then User should be able to Resume Application in Onboarding 
    And Complete the Consumer Deposit Task

     @Smoke
  Scenario: Tc_002
    Given User is on DOA HomePage
    When User selects service type as 'Personal'
    And Product as 'Certificate of Deposit','6 Month CD'
    Then On Clicking OpenNow User should be Navigated to Basic InformationPage
    When User fills all Basic Information and clicks Next
      | incomeRange | politicallyExposedPerson | businessOrCommercialPurpose |
      | $100,000+   | No                       | No                          |
    Then Certificate of Deposit Page should be displayed
    When User fills Details for COD Page and click Next
      | frequency | method       |
      | Annually   | Posted to CD |
    Then Agreements Page Should be loaded
    When User Submits the Application
    Then User should be able to Resume Application in Onboarding 
    And Complete the Consumer Deposit Task
    
     @Smoke
  Scenario: Tc_003
    Given User is on DOA HomePage
    When User selects service type as 'Personal'
    And Product as 'Certificate of Deposit','9 Month CD'
    Then On Clicking OpenNow User should be Navigated to Basic InformationPage
    When User fills all Basic Information and clicks Next
      | incomeRange | politicallyExposedPerson | businessOrCommercialPurpose |
      | $100,000+   | No                       | No                          |
    Then Certificate of Deposit Page should be displayed
    When User fills Details for COD Page and click Next
      | frequency | method       |
      | Annually   | Posted to CD |
    Then Agreements Page Should be loaded
    When User Submits the Application
    Then User should be able to Resume Application in Onboarding 
    And Complete the Consumer Deposit Task
    
       @Smoke
  Scenario: Tc_004
    Given User is on DOA HomePage
    When User selects service type as 'Personal'
    And Product as 'Certificate of Deposit','12 Month CD'
    Then On Clicking OpenNow User should be Navigated to Basic InformationPage
    When User fills all Basic Information and clicks Next
      | incomeRange | politicallyExposedPerson | businessOrCommercialPurpose |
      | $100,000+   | No                       | No                          |
    Then Certificate of Deposit Page should be displayed
    When User fills Details for COD Page and click Next
      | frequency | method       |
      | Annually   | Posted to CD |
    Then Agreements Page Should be loaded
    When User Submits the Application
    Then User should be able to Resume Application in Onboarding 
    And Complete the Consumer Deposit Task
    
       @Smoke
  Scenario: Tc_005
    Given User is on DOA HomePage
    When User selects service type as 'Personal'
    And Product as 'Certificate of Deposit','18 Month CD'
    Then On Clicking OpenNow User should be Navigated to Basic InformationPage
    When User fills all Basic Information and clicks Next
      | incomeRange | politicallyExposedPerson | businessOrCommercialPurpose |
      | $100,000+   | No                       | No                          |
    Then Certificate of Deposit Page should be displayed
    When User fills Details for COD Page and click Next
      | frequency | method       |
      | Annually   | Posted to CD |
    Then Agreements Page Should be loaded
    When User Submits the Application
    Then User should be able to Resume Application in Onboarding 
    And Complete the Consumer Deposit Task
    
       @Smoke
  Scenario: Tc_006
    Given User is on DOA HomePage
    When User selects service type as 'Personal'
    And Product as 'Certificate of Deposit','24 Month CD'
    Then On Clicking OpenNow User should be Navigated to Basic InformationPage
    When User fills all Basic Information and clicks Next
      | incomeRange | politicallyExposedPerson | businessOrCommercialPurpose |
      | $100,000+   | No                       | No                          |
    Then Certificate of Deposit Page should be displayed
    When User fills Details for COD Page and click Next
      | frequency | method       |
      | Annually   | Posted to CD |
    Then Agreements Page Should be loaded
    When User Submits the Application
    Then User should be able to Resume Application in Onboarding 
    And Complete the Consumer Deposit Task
    
     @Smoke
  Scenario: Tc_007
    Given User is on DOA HomePage
    When User selects service type as 'Personal'
    And Product as 'Certificate of Deposit','36 Month CD'
    Then On Clicking OpenNow User should be Navigated to Basic InformationPage
    When User fills all Basic Information and clicks Next
      | incomeRange | politicallyExposedPerson | businessOrCommercialPurpose |
      | $100,000+   | No                       | No                          |
    Then Certificate of Deposit Page should be displayed
    When User fills Details for COD Page and click Next
      | frequency | method       |
      | Annually   | Posted to CD |
    Then Agreements Page Should be loaded
    When User Submits the Application
    Then User should be able to Resume Application in Onboarding 
    And Complete the Consumer Deposit Task
    
       @Smoke
  Scenario: Tc_008
    Given User is on DOA HomePage
    When User selects service type as 'Personal'
    And Product as 'Certificate of Deposit','48 Month CD'
    Then On Clicking OpenNow User should be Navigated to Basic InformationPage
    When User fills all Basic Information and clicks Next
      | incomeRange | politicallyExposedPerson | businessOrCommercialPurpose |
      | $100,000+   | No                       | No                          |
    Then Certificate of Deposit Page should be displayed
    When User fills Details for COD Page and click Next
      | frequency | method       |
      | Annually   | Posted to CD |
    Then Agreements Page Should be loaded
    When User Submits the Application
    Then User should be able to Resume Application in Onboarding 
    And Complete the Consumer Deposit Task
       @Smoke
  Scenario: Tc_009
    Given User is on DOA HomePage
    When User selects service type as 'Personal'
    And Product as 'Certificate of Deposit','60 Month CD'
    Then On Clicking OpenNow User should be Navigated to Basic InformationPage
    When User fills all Basic Information and clicks Next
      | incomeRange | politicallyExposedPerson | businessOrCommercialPurpose |
      | $100,000+   | No                       | No                          |
    Then Certificate of Deposit Page should be displayed
    When User fills Details for COD Page and click Next
      | frequency | method       |
      | Annually   | Posted to CD |
    Then Agreements Page Should be loaded
    When User Submits the Application
    Then User should be able to Resume Application in Onboarding 
    And Complete the Consumer Deposit Task
    
   @Smoke
   Scenario: Tc_010
    Given User is on DOA HomePage
    When User selects service type as 'Personal'
    And Product as 'Checking','TAB Chrome Checking'
    Then On Clicking OpenNow User should be Navigated to Basic InformationPage
    When User fills all Basic Information and clicks Next
      | incomeRange | politicallyExposedPerson | businessOrCommercialPurpose |
      | $100,000+   | No                       | No                          | 
    Then Agreements Page Should be loaded
    When User Submits the Application
    Then User should be able to Resume Application in Onboarding 
    And Complete the Consumer Checking Deposit Task
    @Smoke
    Scenario: Tc_011
    Given User is on DOA HomePage
    When User selects service type as 'Personal'
    And Product as 'Checking','High Yield Checking'
    Then On Clicking OpenNow User should be Navigated to Basic InformationPage
    When User fills all Basic Information and clicks Next
      | incomeRange | politicallyExposedPerson | businessOrCommercialPurpose |
      | $100,000+   | No                       | No                          | 
    Then Agreements Page Should be loaded
    When User Submits the Application
    Then User should be able to Resume Application in Onboarding 
    And Complete the Consumer Checking Deposit Task 
   @Smoke
    Scenario: Tc_012
    Given User is on DOA HomePage
    When User selects service type as 'Personal'
    And Product as 'Checking','365 Checking'
    Then On Clicking OpenNow User should be Navigated to Basic InformationPage
    When User fills all Basic Information and clicks Next
      | incomeRange | politicallyExposedPerson | businessOrCommercialPurpose |
      | $100,000+   | No                       | No                          | 
    Then Agreements Page Should be loaded
    When User Submits the Application
    Then User should be able to Resume Application in Onboarding 
    And Complete the Consumer Checking Deposit Task 
    @Smoke
    Scenario: Tc_013
    Given User is on DOA HomePage
    When User selects service type as 'Personal'
    And Product as 'Checking','Kasasa Cash'
    Then On Clicking OpenNow User should be Navigated to Basic InformationPage
    When User fills all Basic Information and clicks Next
      | incomeRange | politicallyExposedPerson | businessOrCommercialPurpose |
      | $100,000+   | No                       | No                          | 
    Then Agreements Page Should be loaded
    When User Submits the Application
    Then User should be able to Resume Application in Onboarding 
    And Complete the Consumer Checking Deposit Task
    
    @Smoke
    Scenario: Tc_014
    Given User is on DOA HomePage
    When User selects service type as 'Personal'    
    And Product as 'Checking','Kasasa Saver'
    Then On Clicking OpenNow User should be Navigated to Basic InformationPage
    When User fills all Basic Information and clicks Next
      | incomeRange | politicallyExposedPerson | businessOrCommercialPurpose |
      | $100,000+   | No                       | No                          | 
    Then Agreements Page Should be loaded
    When User Submits the Application
    Then User should be able to Resume Application in Onboarding 
    And Complete the Consumer Checking Deposit Task 
    
    @Smoke  
    Scenario: Tc_015
    Given User is on DOA HomePage
    When User selects service type as 'Personal'    
    And Product as 'Money Market Account','Money Market Account'
    Then On Clicking OpenNow User should be Navigated to Basic InformationPage
    When User fills all Basic Information and clicks Next
      | incomeRange | politicallyExposedPerson | businessOrCommercialPurpose |
      | $100,000+   | No                       | No                          | 
    Then Agreements Page Should be loaded
    When User Submits the Application
    Then User should be able to Resume Application in Onboarding 
    And Complete the Consumer Checking Deposit Task 
    
    @Smoke
    Scenario: Tc_016
    Given User is on DOA HomePage
    When User selects service type as 'Personal'    
    And Product as 'Savings','High Yield Savings'
    Then On Clicking OpenNow User should be Navigated to Basic InformationPage
    When User fills all Basic Information and clicks Next
      | incomeRange | politicallyExposedPerson | businessOrCommercialPurpose |
      | $100,000+   | No                       | No                          | 
    Then Agreements Page Should be loaded
    When User Submits the Application
    Then User should be able to Resume Application in Onboarding 
    And Complete the Consumer Checking Deposit Task 
    
    @Smoke
    Scenario: Tc_017
    Given User is on DOA HomePage
    When User selects service type as 'Personal'    
    And Product as 'Savings','Premium Savings'
    Then On Clicking OpenNow User should be Navigated to Basic InformationPage
    When User fills all Basic Information and clicks Next
      | incomeRange | politicallyExposedPerson | businessOrCommercialPurpose |
      | $100,000+   | No                       | No                          | 
    Then Agreements Page Should be loaded
    When User Submits the Application
    Then User should be able to Resume Application in Onboarding 
    And Complete the Consumer Checking Deposit Task 
    
    @Smoke  @TODO
    Scenario: Tc_018
    Given User is on DOA HomePage
    When User selects service type as 'Business'
    And Business Product as 'Certificate of Deposit','3 Month CD'
    Then On Clicking OpenNow User should be Navigated to Basic InformationPage 
    When User fills all Legal Entity Information and clicks Next
      |Legal Entity|
       |Limited Liability Company|
    Then Certificate of Deposit Page should be displayed
    When User fills Details for COD Page and click Next
      | frequency | method       |
      | Annually   | Posted to CD |
    Then Agreements Page Should be loaded
    When User Submits the Application
    Then User should be able to Resume Application in Onboarding 
    And Complete the Consumer Deposit Task

     