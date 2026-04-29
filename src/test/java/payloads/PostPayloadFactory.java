package payloads;

import java.util.HashMap;
import java.util.Map;

public class PostPayloadFactory {

    private PostPayloadFactory() {
        // Private constructor to prevent instantiation
    }

    public static Map<String, Object> createPostPayload() {
        Map<String, Object> payload = new HashMap<>();

        payload.put("title", "Senior QA Automation Portfolio");
        payload.put("body", "API automation framework using Java, RestAssured, Cucumber and Maven");
        payload.put("userId", 10);

        return payload;
    }

    public static Map<String, Object> updatePostPayload() {
        Map<String, Object> payload = new HashMap<>();

        payload.put("id", 1);
        payload.put("title", "Updated QA Automation Framework");
        payload.put("body", "Updated API test automation project with full CRUD validation");
        payload.put("userId", 10);

        return payload;
    }

    public static Map<String, Object> updatePostTitlePayload() {
        Map<String, Object> payload = new HashMap<>();

        payload.put("title", "Partially Updated Post Title");

        return payload;
    }
}