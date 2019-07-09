
Feature: Test User API

  Background:
    Given url 'http://flcncapp-is05asf.tsl.telus.com/rest/api/kitsuneServices/v1/getStatus?action=milestone&Ids=9149137571313366743'
    * def orderNumber = '9149137571313366743'
    * def type = 'New/Change Business Internet Product Order'

  @FR
  Scenario: Fetch All Order Milestone
    When method GET
    Then status 200

  @FR
  Scenario: Verify Order Number and Order Type is what we defined
    When method GET
    And status 200
    Then  print response.data[0].id
    Then  match response.data[0].id == orderNumber
    Then  match response.data[0].type == type

  @FR
  Scenario: Verify Product Order has five milestones
      When method GET
      And status 200
      Then match response.data[0].milestones.length() == 5

