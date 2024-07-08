package sample.picsart.api.model;


import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.LinkedHashMap;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@With
public class User {
    Integer id;
    String name;
    String username;
    String email;
    LinkedHashMap<String, Object> address;
    String phone;
    String website;
    LinkedHashMap<String, Object> company;

}
