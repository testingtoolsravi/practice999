@EBank @Web @Regression
Feature: EBank

  Background: User Has Logged into EBank With Valid Credentials
    Given user logged into EBank as 'auto01' and 'abc123'

  Scenario: TC_eBank_0001
    When User is Logged in and All options are Displayed
    Then Below Tabs should be available to the user
      | BPM | Reports | Accounting | Administration | Administration | Help |

  Scenario: TC_eBank_0002
    When User is Logged in and All options are Displayed
    Then Below Accounting Tab should be Journal Entry Tab
    And Below Journal Entry Tab Should be below Options
      | Access Groups | Journal Batch | Template Management | Batch Transaction History |

  Scenario: TC_eBank_0003
    When User navigates to Access Groups
    Then Access Groups Page should have below Options
      | Search | Add Search Condition | Create | Edit | Remove | Excel | Export Access Group Data |

  @Smoke
  Scenario: TC_eBank_0004
    Given User is Logged in and All options are Displayed
    When User navigates to Acess Group and create a new Access Group
      | userAccessGroup       | accountAccessType | accountNumber | branch | type  |
      | Administrator [admin] | GLA               |       1011138 |   1220 | debit |
    Then Access group should be created Successfully
    And user should be able to edit search download and remove actions Successfully

  @Smoke
  Scenario: TC_eBank_0005
    Given User is Logged in and All options are Displayed
    When User navigates to Journal Batch
    Then On Journal Batch screen search create edit remove addsearchcondtion and excel options should be displayed

  @TODO
  Scenario: TC_eBank_0006
    Given User is Logged in and  navigates to Journal Batch
    When Creates a New Batch and Clicks Save

  @Smoke
  Scenario: TC_eBank_0007
    Given User is Logged in and All options are Displayed
    When User navigates to Template Management
    Then On Template Management screen create edit remove Excel search and addsearchcondtion options should be displayed

  @TODO
  Scenario: TC_eBank_0008
    Given User is Logged in and  navigates to Journal Batch
    When Creates a New Batch and Clicks Save

  Scenario: TC_eBank_0009
    When User navigates to Batch Transaction History
    Then On Batch Transaction page bel should be displayed
      | Search | Add Search Condition | Refresh | Excel |

  @Smoke
  Scenario: TC_eBank_0010
    Given User is Logged in and All options are Displayed
    When User navigates to Batch Transaction History
    Then User should be able to Download Excel Data and perform search

  Scenario: TC_eBank_0011
    Given User is Logged in and All options are Displayed
    When User Expands Maintenance Option
    Then In Maintenance tab below options should be displayed
      | Entities | Interest Rates |
   
 Scenario: TC_eBank_0012
    Given User is Logged in and All options are Displayed
    When User Navigates to Entities Page
    Then Application should navigate to Entities Page  
    
   
 Scenario: TC_eBank_0013
    Given User is Logged in and All options are Displayed
    When User Navigates to Interest Rates Page
    Then Interest Rates Page should have below options 
      | Search | Create |Add Search Conditon|Edit|
    
  @Smoke
  Scenario: TC_eBank_0014
    Given User is Logged in and All options are Displayed
    When User create a Interest with Active Status
    Then Active Status not allowed Warning should be Displayed
    When user changes Status to Pending
    Then Interest should be saved
    When user changes status to Active After Saving
    Then Same user cannot change Status warning Should be Displayed
    When users update any Interest data
    Then changes should be updated
    And user should be able to seach for the Interest Rate
    When user logsin with Other User and changes Status to Active
    Then Product should be saved with Active Status
    
       
 Scenario: TC_eBank_0015
    Given User is Logged in and All options are Displayed
    When User Expands Administration Tab
    Then Administration Tab should have below options 
   |Users|Access Groups|Roles|Dynamic Attributes|User Sessions|Locks|External Files||Email History|Scheduled Tasks|Restore Deleted Entities|Entity Inspector|Application Properties|JMX Console|Entity Log|Server Log|Screen Profiler|Performance Statistics|

     
 Scenario: TC_eBank_0016
    Given User is Logged in and All options are Displayed
    When User Navigates to Scheduled Tasks
    Then Scheduled tasks Page should have below options 
    | Search | Create |Add Search Conditon|Edit|Activate|Remove|Execution History|
   
   