package steps;

import clients.PostClient;
import config.EnvironmentConfig;
import context.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import payloads.PostPayloadFactory;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class PostSteps {

    private final TestContext testContext = new TestContext();
    private final PostClient postClient = new PostClient();

    private String baseUri;

    @Given("I have the posts API endpoint configured")
    public void iHaveThePostsApiEndpointConfigured() {
        baseUri = EnvironmentConfig.getBaseUri();
    }

    @When("I send a GET request to search for post with id {int}")
    public void iSendAGetRequestToSearchForPostWithId(int postId) {
        testContext.setResponse(postClient.getPostById(baseUri, postId));
    }

    @When("I send a GET request to list all posts")
    public void iSendAGetRequestToListAllPosts() {
        testContext.setResponse(postClient.getAllPosts(baseUri));
    }

    @When("I send a POST request to create a new post")
    public void iSendAPostRequestToCreateANewPost() {
        testContext.setResponse(postClient.createPost(baseUri));
    }

    @When("I send a PUT request to update post with id {int}")
    public void iSendAPutRequestToUpdatePostWithId(int postId) {
        testContext.setResponse(postClient.updatePost(baseUri, postId));
    }

    @When("I send a PATCH request to update the post title with id {int}")
    public void iSendAPatchRequestToUpdateThePostTitleWithId(int postId) {
        testContext.setResponse(postClient.updatePostTitle(baseUri, postId));
    }

    @When("I send a DELETE request for post with id {int}")
    public void iSendADeleteRequestForPostWithId(int postId) {
        testContext.setResponse(postClient.deletePost(baseUri, postId));
    }

    @Then("the API should return status code {int}")
    public void theApiShouldReturnStatusCode(int expectedStatusCode) {
        assertThat(testContext.getResponse().getStatusCode(), equalTo(expectedStatusCode));
    }

    @Then("the response should contain the post title {string}")
    public void theResponseShouldContainThePostTitle(String expectedTitle) {
        String actualTitle = testContext.getResponse().jsonPath().getString("title");
        assertThat(actualTitle, equalTo(expectedTitle));
    }

    @Then("the response should contain user id {int}")
    public void theResponseShouldContainUserId(int expectedUserId) {
        Integer actualUserId = testContext.getResponse().jsonPath().getInt("userId");
        assertThat(actualUserId, equalTo(expectedUserId));
    }

    @Then("the response should contain a list of posts")
    public void theResponseShouldContainAListOfPosts() {
        int postsSize = testContext.getResponse().jsonPath().getList("$").size();
        assertThat(postsSize, greaterThan(0));
    }

    @Then("the response should contain the created post data")
    public void theResponseShouldContainTheCreatedPostData() {
        String title = testContext.getResponse().jsonPath().getString("title");
        String body = testContext.getResponse().jsonPath().getString("body");
        Integer userId = testContext.getResponse().jsonPath().getInt("userId");

        assertThat(title, equalTo(PostPayloadFactory.createPostPayload().get("title")));
        assertThat(body, equalTo(PostPayloadFactory.createPostPayload().get("body")));
        assertThat(userId, equalTo(PostPayloadFactory.createPostPayload().get("userId")));
    }

    @Then("the response should contain the updated post data")
    public void theResponseShouldContainTheUpdatedPostData() {
        Integer id = testContext.getResponse().jsonPath().getInt("id");
        String title = testContext.getResponse().jsonPath().getString("title");
        String body = testContext.getResponse().jsonPath().getString("body");
        Integer userId = testContext.getResponse().jsonPath().getInt("userId");

        assertThat(id, equalTo(PostPayloadFactory.updatePostPayload().get("id")));
        assertThat(title, equalTo(PostPayloadFactory.updatePostPayload().get("title")));
        assertThat(body, equalTo(PostPayloadFactory.updatePostPayload().get("body")));
        assertThat(userId, equalTo(PostPayloadFactory.updatePostPayload().get("userId")));
    }

    @Then("the response should contain the updated title")
    public void theResponseShouldContainTheUpdatedTitle() {
        String title = testContext.getResponse().jsonPath().getString("title");
        assertThat(title, equalTo(PostPayloadFactory.updatePostTitlePayload().get("title")));
    }

    @Then("the response should match the post contract schema")
    public void theResponseShouldMatchThePostContractSchema() {
        testContext.getResponse()
                .then()
                .body(matchesJsonSchemaInClasspath("schemas/post-schema.json"));
    }

    @Then("the response should match the posts list contract schema")
    public void theResponseShouldMatchThePostsListContractSchema() {
        testContext.getResponse()
                .then()
                .body(matchesJsonSchemaInClasspath("schemas/post-list-schema.json"));
    }
}