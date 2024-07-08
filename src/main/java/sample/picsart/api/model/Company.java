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
public class Company {
    String name;
    String catchPhrase;
    String bs;
}
