package http.ch03;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//{
//        "userId": 3,
//        "id": 50,
//        "title": "cupiditate necessitatibus ullam aut quis dolor voluptate",
//        "completed": true
//}
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    private int userId;
    private int id;
    private String title;
    private boolean completed;


}
