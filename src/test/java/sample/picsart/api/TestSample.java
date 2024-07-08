package sample.picsart.api;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import sample.picsart.api.model.Post;
import sample.picsart.api.model.User;
import sample.picsart.api.services.PostService;
import sample.picsart.api.services.UsersService;

import java.util.List;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class TestSample {

    @Test(description = "Test scenario based on task")
    public void verificationOfPostCreationByUser() {
        int randomInt = new Faker().number().numberBetween(0, 10);

        Response userResponse = new UsersService()
                .getUsers();
        User user = userResponse.jsonPath().getList("", User.class).get(randomInt);
        String email = user.getEmail();

        System.out.println(email);
        Integer userId = user.getId();

        List<Post> posts = new PostService()
                .getAllPosts().jsonPath().getList("", Post.class);

        assertValidPostIds(posts, userId);

        Post post = new Post()
                .withUserId(userId)
                .withBody("Test body")
                .withTitle("Test tittle");

        Post response = new PostService()
                .createPost(post)
                .then()
                .statusCode(201)
                .extract().body().as(Post.class);

        assertEquals(response.getUserId(),post.getUserId());
        assertEquals(response.getBody(),post.getBody());
        assertEquals(response.getTitle(),post.getTitle());


    }

    public void assertValidPostIds(List<Post> posts, Integer userId) {
        for (Post post : posts) {
            if (post.getUserId().equals(userId)) {
                boolean isValidPostId = post.getId() > 0 && post.getId() < 101;
                assertTrue(isValidPostId);
            }
        }
    }


}
