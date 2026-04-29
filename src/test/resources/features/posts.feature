# language: en

@api @posts
Feature: Posts API validation

  As a QA Automation Engineer
  I want to validate posts API endpoints
  So that I can ensure the API behavior and contract are working as expected

  Background:
    Given I have the posts API endpoint configured

  @smoke @get
  Scenario: Validate single post search successfully
    When I send a GET request to search for post with id 1
    Then the API should return status code 200
    And the response should contain the post title "sunt aut facere repellat provident occaecati excepturi optio reprehenderit"
    And the response should contain user id 1
    And the response should match the post contract schema

  @negative @get
  Scenario: Validate post not found
    When I send a GET request to search for post with id 999
    Then the API should return status code 404

  @regression @get
  Scenario: Validate posts list successfully
    When I send a GET request to list all posts
    Then the API should return status code 200
    And the response should contain a list of posts
    And the response should match the posts list contract schema

  @smoke @post
  Scenario: Validate post creation successfully
    When I send a POST request to create a new post
    Then the API should return status code 201
    And the response should contain the created post data

  @regression @put
  Scenario: Validate full post update successfully
    When I send a PUT request to update post with id 1
    Then the API should return status code 200
    And the response should contain the updated post data

  @regression @patch
  Scenario: Validate partial post update successfully
    When I send a PATCH request to update the post title with id 1
    Then the API should return status code 200
    And the response should contain the updated title

  @regression @delete
  Scenario: Validate post deletion successfully
    When I send a DELETE request for post with id 1
    Then the API should return status code 200