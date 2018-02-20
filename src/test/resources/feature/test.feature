Feature: Testing various request on USA State list

@TEST
@POSITIVE
Scenario: Check if users can access groupkt application
When User sends a GET request to the endpoint,they must get back a valid status code 200

@TEST
@NEGATIVE
Scenario: Check if users get no match found messagewhen users tries to access an invalid resources
When Users sends invalid resources,then they must get back verify no match found message

@TEST
@POSITIVE
Scenario Outline: Check users should get capital and largest city when state code or abbrivation is provided
When users provides state code or abbrivation <state_code_or_abbrivation>,Then capital <capital> and largest city <largest_city> names should be retrieved

Examples:
|state_code_or_abbrivation 	|capital			|largest_city	|
|AL							|Montgomery			|Birmingham		|
|Missouri					|Jefferson City		|Kansas City	|
|New York					|Albany				|New York City	|
|ND							|Bismarck			|Fargo			|
|TX							|Austin				|Houston		|

@TEST
@NEGATIVE
Scenario Outline: Check users get no match found message when invalid state code or abbrivation is provided
When users provides invalid state code or abbrivation <state_code_or_abbrivation>,Then no match found message names should be retrieved

Examples:
|state_code_or_abbrivation 	|
|A3							|
|Miss555					|
|New 22						|
|N 							|
|T&							|
