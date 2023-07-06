@tag
Feature: Footer validations
	
	Background:
	Given User is landed on the landing page
	
  @tag1
  Scenario: Verify support email
    Then support email is "support@mapsherpa.com"
    
  @tag1
  Scenario: Verify address
    Then address is "MapSherpa Inc, 1953 Bromley Road, Ottawa, Ontario, Canada, K2A 1C3"

   
