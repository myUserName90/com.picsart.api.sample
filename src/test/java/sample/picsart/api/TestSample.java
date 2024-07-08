package sample.picsart.api;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import sample.picsart.api.model.Post;
import sample.picsart.api.model.User;
import sample.picsart.api.services.PostService;
import sample.picsart.api.services.UsersService;

import java.util.List;

import static org.testng.AssertJUnit.assertTrue;

public class TestSample {

    @Test
    public void test() {
        int randomInt = new Faker().number().numberBetween(0, 10);

        Response userResponse = new UsersService()
                .getUsers();
        User user = userResponse.jsonPath().getList("", User.class).get(randomInt);
        String email = user.getEmail();

        System.out.println(email);
        Integer id = user.getId();

        List<Post> posts = new PostService()
                .getAllPosts().jsonPath().getList("", Post.class);

        assertValidPostIds(posts, id);


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
