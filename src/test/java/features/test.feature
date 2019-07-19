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

  Scenario Outline: Test configuration for "<Environment>"
    Given I set APIKey for DAServer as "<APIKey>"
#    And I set endpoint as "<DABroker>"
#    And I restart DAServer
#    Then DAServer joins channel successfully
#
#    Examples:
#      | Environment | APIKey                                                   | DABroker                                                 |
#      | US1         | OqTAyyL1Q1T6yVcHKinqcYV4Y2KA9q/IO01cmIcd3JQvuUWHLNMi7w== | https://devdav2broker0.centralus.cloudapp.azure.com:8079 |
#      | US2         | bHtxMAAQiCvs5iPJFnYfQVGLVyFFOKY6ADG0hLo                  | https://dabroker.sendwordnow.com                         |
#      | US3         | bHtxMAAQiCvs5iPJFnYfQVGLVyFFOKY6ADG0hLo                  | https://dabroker.sendwordnow.com                         |

  Scenario: Test email
    Then I send report email