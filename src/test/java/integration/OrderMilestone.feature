
Feature: Test User API

  Background:
    Given url 'http://flcncapp-is05asf.tsl.telus.com/rest/api/kitsuneServices/v1/getStatus?action=milestone&Ids=9149137571313366743'


  @FR
  Scenario: Fetch All Order Milestone
    When method GET
    Then status 200

  @FR
  Scenario: Verify Order Milestone
    When method GET
    And status 200
    Then  print response.data[0]


  @FR
  Scenario: Verify a Json value
    When def myJson = {foo:'bar', baz:[1,2,3]}
    Then match myJson.foo == 'bar'

