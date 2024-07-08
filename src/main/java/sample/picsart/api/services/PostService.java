package sample.picsart.api.services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import sample.picsart.api.model.Post;

import static sample.picsart.api.config.Url.POSTS_ENDPOINT;

public class PostService extends BaseService {

    public Response getAllPosts(){
        RequestSpecification request= configRequestAPI()
                .basePath(POSTS_ENDPOINT);
        return get(request);
    }

    public Response createPost(Post post){
        RequestSpecification request= configRequestAPI()
                .basePath(POSTS_ENDPOINT)
                .body(post);
        return post(request);
    }
}
