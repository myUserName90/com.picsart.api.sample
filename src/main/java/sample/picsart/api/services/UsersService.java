package sample.picsart.api.services;

import io.restassured.specification.RequestSpecification;
import sample.picsart.api.model.dto.UsersResponse;

import static sample.picsart.api.config.Url.USERS_ENDPOINT;

public class UsersService extends BaseService {

    public UsersResponse getUsers() {
        RequestSpecification request = configRequestAPI()
                .basePath(USERS_ENDPOINT);
        return get(request).as(UsersResponse.class);
    }
}
