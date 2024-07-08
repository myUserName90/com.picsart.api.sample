package sample.picsart.api.model;

import groovy.transform.builder.Builder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@With
public class Post {
    Integer userId;
    Integer id;
    String title;
    String body;
}
