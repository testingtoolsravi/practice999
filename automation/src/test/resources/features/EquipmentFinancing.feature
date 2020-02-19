  @EquipmentFinancing @Web @Regression
  Feature: Equipment Financing
  
  Background: Load user Information
    Given loads users  data
  
  @Smoke     
  Scenario: TC001
    Given User is on BasicInfo Page
     When user create an application with Entity as
      | LegalEntity | secondApplicantType | 
      | Corporation | Invite              | 
     Then Application Should be Displayed in OnBoarding After Submission
  
  @Smoke    
  Scenario: TC002
    Given User is on BasicInfo Page
     When user create an application with Entity as
      | LegalEntity   | secondApplicantType | 
      | S-Corporation | Invite              | 
     Then Application Should be Displayed in OnBoarding After Submission
  @Smoke
  Scenario: TC003
    Given User is on BasicInfo Page
     When user create an application with Entity as
      | LegalEntity         | secondApplicantType | 
      | General Partnership | Invite              | 
     Then Application Should be Displayed in OnBoarding After Submission
  @Smoke
  Scenario: TC004
    Given User is on BasicInfo Page
     When user create an application with Entity as
      | LegalEntity               | secondApplicantType | 
      | Limited Liability Company | Invite              | 
     Then Application Should be Displayed in OnBoarding After Submission
  @Smoke    
  Scenario: TC005
    Given User is on BasicInfo Page
     When user create an application with Entity as Sole PropReitor
      | LegalEntity     | secondApplicantType | 
      | Sole proprietor | Invite              | 
     Then Application Should be Displayed in OnBoarding After Submission
  @Smoke 
  Scenario: TC006
    Given User is on BasicInfo Page
     When user create an application with Entity as and Second Applicant Manually
      | LegalEntity | secondApplicantType | 
      | Corporation | Manual              | 
     Then Application Should be Displayed in OnBoarding After Submission
  @Smoke    
  Scenario: TC007
    Given User is on BasicInfo Page
     When user create an application with Entity as and Second Applicant Manually
      | LegalEntity   | secondApplicantType | 
      | S-Corporation | Manual              | 
     Then Application Should be Displayed in OnBoarding After Submission
  @Smoke  
  Scenario: TC008
    Given User is on BasicInfo Page
     When user create an application with Entity as and Second Applicant Manually
      | LegalEntity         | secondApplicantType | 
      | General Partnership | Manual              | 
     Then Application Should be Displayed in OnBoarding After Submission
  @Smoke  
  Scenario: TC009
    Given User is on BasicInfo Page
     When user create an application with Entity as and Second Applicant Manually
      | LegalEntity               | secondApplicantType | 
      | Limited Liability Company | Manual              | 
     Then Application Should be Displayed in OnBoarding After Submission
  @Smoke 
  Scenario: TC010
    Given User is on BasicInfo Page
     When user create an application with Entity as Sole Propreitor and Second Applicant Manually
      | LegalEntity     | secondApplicantType | 
      | Sole proprietor | Manual              | 
     Then Application Should be Displayed in OnBoarding After Submission
  
  