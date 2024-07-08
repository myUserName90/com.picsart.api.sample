package sample.picsart.api.model.dto;

import lombok.*;
import sample.picsart.api.model.User;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UsersResponse {
    private List<User> userList;
}
