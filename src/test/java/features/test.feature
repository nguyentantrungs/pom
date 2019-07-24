Feature: Login and Send message Feature
  Verify if user is able to login DAClient then receive message


#  Scenario: Login DAClient in basic mode
#    Given I open DAClient
#    When I input following credentials to DAClient
#      | username | password |
#      | 1        | abcd1234 |
#    Then I should see "Invalid username or password. Try again." message in login screen
#    And DAClient icon is "red"
#    When I input following credentials to DAClient
#      | username      | password |
#      | steven.nguyen | abcd1234 |
#    Then DAClient icon is "blue"


#  Scenario: Send message from WebUI
##    Given I open browser
##    And I am on "https://idsrv-vndev2.devops.onsolve.com/account/SignIn" page
##    When I input following credentials to WebUI
##      | username     | password |
##      | stevennguyen | abcd1234 |
##    Then I should see Dashboard
##    When I click "Send Message on Dashboard"
##    And I click "Master"
##    And I click "Next"
##    And I click "Deselect All"
##    And I search for "steven.nguyen"
##    And I click "Search"
##    And I click "searched contact"
##    And I click "Next"
##    And I input subject and message body
##    And I click "Send Message"
#
#  Scenario: Check new message on DAClient
#    Given I switch to AlertMessage screen
#    When I check message status "Alert Status: Unread"
#    And I click "Mark As Read" on DAClient
#    And I check message status "Alert Status: Read"
#    And I click "Close" on DAClient
#    And I exit DAClient
#
#  Scenario: Test API
#    Given I request API

  Scenario Outline: On-prem DAServer Registration and Send Message "<Environment>"
    Given I set APIKey for DAServer as "<APIKey>"
    And I set endpoint as "<DABroker>"
    And I restart DAServer
    Then DAServer joins channel successfully

    When I open DAClient
    And I input following credentials to DAClient
      | username            | password        |
      | <DAClient_username> | <DAClient_pass> |
    Then DAClient icon is "blue"


    When I open browser
    And I am on "<LoginPage>" page
    And I input following credentials to WebUI
      | username         | password     |
      | <WebUI_username> | <WebUI_pass> |
    Then I should see Dashboard
    When I click "Create Alert on Dashboard"
    And I click "DATeam"
    And I click "Next"
    And I click "Deselect All"
    And I search for "hoa.luong"
    And I click "searched contact"
    And I click "Next"
    And I input subject and message body
    And I click "Send Message"
    Then Message status should be Delivered to DA Server

    Given I switch to AlertMessage screen
    Then I should see message from previous step
    When I check message status "Alert Status: Unread"
    And I click "Mark As Read" on DAClient
    And I check message status "Alert Status: Read"
    And I click "Close" on DAClient
    And I exit DAClient
#
#    When I stop DAServer

    Examples:
      | Environment | APIKey                                  | DABroker                         | LoginPage                     | DAClient_username | DAClient_pass | WebUI_username | WebUI_pass |
      | CA          | gWxG3IK24pShaJJZAc5QCzUWISnXKbqlfVSFzV8 | https://dabroker.sendwordnow.ca  | https://idsrv.sendwordnow.ca  | hoaluong.ca       | 2HqhwW4y      | hoaluong.ca    | 2HqhwW4y   |
      | EU          | WjnF9FLcAIPUUQeEoVOoqzU7157jAKg38kLVY   | https://dabroker.sendwordnow.eu  | https://idsrv.sendwordnow.eu  | hoaluong.eu       | 2HqhwW4y      | hoaluong.eu    | 2HqhwW4y   |
      | US          | bHtxMAAQiCvs5iPJFnYfQVGLVyFFOKY6ADG0hLo | https://dabroker.sendwordnow.com | https://idsrv.sendwordnow.com | hoaluong.us       | 2HqhwW4y      | hoaluong.us    | 2HqhwW4y   |

#  Scenario: Stop DAServer
#    Given I stop DAServer