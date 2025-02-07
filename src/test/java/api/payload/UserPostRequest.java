package api.payload;

import java.util.HashMap;
import java.util.Map;

public class UserPostRequest {

    public static Map<String, Object> requestBody(String firstName, String jobTitle)
    {
        Map<String, Object> requestBody = new HashMap<>();
        requestBody.put("name", firstName);
        requestBody.put("job", jobTitle);
        return requestBody;
    }
}
