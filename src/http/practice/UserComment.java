package http.practice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserComment {
    private int postId;
    private int id;
    private String name;
    private String email;
    private String body;


}
