Feature: The project service is useful for all the transactional operations about projects in trackbox

  Scenario: Create a new project
    Given a project named "MakingDevs"
    And the codename is "MAKINGDEVS", with the description "Better developers"
    When I use the projectService
    Then the project must have an id and date created

  Scenario: Create many projects
    Given some projects
    	| name		    | codeName    | description       |
    | MakingDevs    | MAKINGDEVS  | Education project |
    | Stele app     | STELE       | Easy payments     |
    | Training MD   | TRAINING    | Official courses  |
    When I use the projectService on the project's list
    Then each project must have an id and date created

    

