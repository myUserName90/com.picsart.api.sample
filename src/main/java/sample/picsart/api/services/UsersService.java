package sample.picsart.api.services;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static sample.picsart.api.config.Url.USERS_ENDPOINT;

public class UsersService extends BaseService {

    public Response getUsers() {
        RequestSpecification request = configRequestAPI()
                .basePath(USERS_ENDPOINT);
        return get(request);
    }
}
