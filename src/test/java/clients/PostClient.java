package clients;

import io.restassured.response.Response;
import payloads.PostPayloadFactory;
import utils.RestUtils;

public class PostClient {

    private static final String POSTS_ENDPOINT = "/posts";

    public Response getPostById(String baseUri, int postId) {
        return RestUtils.get(baseUri, POSTS_ENDPOINT + "/" + postId);
    }

    public Response getAllPosts(String baseUri) {
        return RestUtils.get(baseUri, POSTS_ENDPOINT);
    }

    public Response createPost(String baseUri) {
        return RestUtils.post(baseUri, POSTS_ENDPOINT, PostPayloadFactory.createPostPayload());
    }

    public Response updatePost(String baseUri, int postId) {
        return RestUtils.put(baseUri, POSTS_ENDPOINT + "/" + postId, PostPayloadFactory.updatePostPayload());
    }

    public Response updatePostTitle(String baseUri, int postId) {
        return RestUtils.patch(baseUri, POSTS_ENDPOINT + "/" + postId, PostPayloadFactory.updatePostTitlePayload());
    }

    public Response deletePost(String baseUri, int postId) {
        return RestUtils.delete(baseUri, POSTS_ENDPOINT + "/" + postId);
    }
}